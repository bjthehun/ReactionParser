package tools.vitruv.reactionsparser.parser;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

public class GenericXtextParser {
    private XtextResource parseResult;
    private List<Issue> issues;

    private void parse(String path){
        // Load the appropriate resource for the Xtext DSL file
        var resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createFileURI(path));
        var resourceSet = resourceServiceProvider.get(ResourceSet.class);
        parseResult = (XtextResource) resourceSet.getResource(URI.createFileURI(path), true);

        // Attempt to parse and validate the DSL file
        var validator = parseResult.getResourceServiceProvider().getResourceValidator();
        issues = validator.validate(parseResult, CheckMode.ALL, CancelIndicator.NullImpl);;
    }

    public EObject getParseResult(String path) throws Exception {
        parse(path);
        if (!issues.isEmpty()) {
            throw new Exception(generateIssuesMessage(issues));
        }

        // return
        return (EObject) parseResult.getContents().get(0);
    }

    public List<Issue> getProblems(String path) {
        parse(path);
        return Collections.unmodifiableList(issues);
    }

    private String generateIssuesMessage(List<Issue> issues) {
        return String.join(System.lineSeparator(), issues.stream().map(issue -> issue.getMessage()).toList());
    }
}