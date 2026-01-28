// Generated from DebugInternalReactionsLanguage.g4 by ANTLR 4.13.2

package tools.vitruv.reactionsparser.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DebugInternalReactionsLanguageParser}.
 */
public interface DebugInternalReactionsLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsFile}.
	 * @param ctx the parse tree
	 */
	void enterReactionsFile(DebugInternalReactionsLanguageParser.ReactionsFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsFile}.
	 * @param ctx the parse tree
	 */
	void exitReactionsFile(DebugInternalReactionsLanguageParser.ReactionsFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#metamodelImport}.
	 * @param ctx the parse tree
	 */
	void enterMetamodelImport(DebugInternalReactionsLanguageParser.MetamodelImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#metamodelImport}.
	 * @param ctx the parse tree
	 */
	void exitMetamodelImport(DebugInternalReactionsLanguageParser.MetamodelImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsSegment}.
	 * @param ctx the parse tree
	 */
	void enterReactionsSegment(DebugInternalReactionsLanguageParser.ReactionsSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsSegment}.
	 * @param ctx the parse tree
	 */
	void exitReactionsSegment(DebugInternalReactionsLanguageParser.ReactionsSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsImport}.
	 * @param ctx the parse tree
	 */
	void enterReactionsImport(DebugInternalReactionsLanguageParser.ReactionsImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#reactionsImport}.
	 * @param ctx the parse tree
	 */
	void exitReactionsImport(DebugInternalReactionsLanguageParser.ReactionsImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#reaction}.
	 * @param ctx the parse tree
	 */
	void enterReaction(DebugInternalReactionsLanguageParser.ReactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#reaction}.
	 * @param ctx the parse tree
	 */
	void exitReaction(DebugInternalReactionsLanguageParser.ReactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void enterRoutineCall(DebugInternalReactionsLanguageParser.RoutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void exitRoutineCall(DebugInternalReactionsLanguageParser.RoutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#trigger}.
	 * @param ctx the parse tree
	 */
	void enterTrigger(DebugInternalReactionsLanguageParser.TriggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#trigger}.
	 * @param ctx the parse tree
	 */
	void exitTrigger(DebugInternalReactionsLanguageParser.TriggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#concreteModelChange}.
	 * @param ctx the parse tree
	 */
	void enterConcreteModelChange(DebugInternalReactionsLanguageParser.ConcreteModelChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#concreteModelChange}.
	 * @param ctx the parse tree
	 */
	void exitConcreteModelChange(DebugInternalReactionsLanguageParser.ConcreteModelChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#modelElementChange}.
	 * @param ctx the parse tree
	 */
	void enterModelElementChange(DebugInternalReactionsLanguageParser.ModelElementChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#modelElementChange}.
	 * @param ctx the parse tree
	 */
	void exitModelElementChange(DebugInternalReactionsLanguageParser.ModelElementChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#modelAttributeChange}.
	 * @param ctx the parse tree
	 */
	void enterModelAttributeChange(DebugInternalReactionsLanguageParser.ModelAttributeChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#modelAttributeChange}.
	 * @param ctx the parse tree
	 */
	void exitModelAttributeChange(DebugInternalReactionsLanguageParser.ModelAttributeChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#arbitraryModelChange}.
	 * @param ctx the parse tree
	 */
	void enterArbitraryModelChange(DebugInternalReactionsLanguageParser.ArbitraryModelChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#arbitraryModelChange}.
	 * @param ctx the parse tree
	 */
	void exitArbitraryModelChange(DebugInternalReactionsLanguageParser.ArbitraryModelChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementExistenceChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementExistenceChangeType(DebugInternalReactionsLanguageParser.ElementExistenceChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementExistenceChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementExistenceChangeType(DebugInternalReactionsLanguageParser.ElementExistenceChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementUsageChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementUsageChangeType(DebugInternalReactionsLanguageParser.ElementUsageChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementUsageChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementUsageChangeType(DebugInternalReactionsLanguageParser.ElementUsageChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementCreationChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementCreationChangeType(DebugInternalReactionsLanguageParser.ElementCreationChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementCreationChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementCreationChangeType(DebugInternalReactionsLanguageParser.ElementCreationChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementDeletionChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementDeletionChangeType(DebugInternalReactionsLanguageParser.ElementDeletionChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementDeletionChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementDeletionChangeType(DebugInternalReactionsLanguageParser.ElementDeletionChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementReferenceChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementReferenceChangeType(DebugInternalReactionsLanguageParser.ElementReferenceChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementReferenceChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementReferenceChangeType(DebugInternalReactionsLanguageParser.ElementReferenceChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementInsertionChangeType(DebugInternalReactionsLanguageParser.ElementInsertionChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementInsertionChangeType(DebugInternalReactionsLanguageParser.ElementInsertionChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionInListChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementInsertionInListChangeType(DebugInternalReactionsLanguageParser.ElementInsertionInListChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionInListChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementInsertionInListChangeType(DebugInternalReactionsLanguageParser.ElementInsertionInListChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionAsRootChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementInsertionAsRootChangeType(DebugInternalReactionsLanguageParser.ElementInsertionAsRootChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementInsertionAsRootChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementInsertionAsRootChangeType(DebugInternalReactionsLanguageParser.ElementInsertionAsRootChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementRemovalChangeType(DebugInternalReactionsLanguageParser.ElementRemovalChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementRemovalChangeType(DebugInternalReactionsLanguageParser.ElementRemovalChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalAsRootChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementRemovalAsRootChangeType(DebugInternalReactionsLanguageParser.ElementRemovalAsRootChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalAsRootChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementRemovalAsRootChangeType(DebugInternalReactionsLanguageParser.ElementRemovalAsRootChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalFromListChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementRemovalFromListChangeType(DebugInternalReactionsLanguageParser.ElementRemovalFromListChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementRemovalFromListChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementRemovalFromListChangeType(DebugInternalReactionsLanguageParser.ElementRemovalFromListChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementReplacementChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementReplacementChangeType(DebugInternalReactionsLanguageParser.ElementReplacementChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementReplacementChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementReplacementChangeType(DebugInternalReactionsLanguageParser.ElementReplacementChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementChangeType}.
	 * @param ctx the parse tree
	 */
	void enterElementChangeType(DebugInternalReactionsLanguageParser.ElementChangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#elementChangeType}.
	 * @param ctx the parse tree
	 */
	void exitElementChangeType(DebugInternalReactionsLanguageParser.ElementChangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#routine}.
	 * @param ctx the parse tree
	 */
	void enterRoutine(DebugInternalReactionsLanguageParser.RoutineContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#routine}.
	 * @param ctx the parse tree
	 */
	void exitRoutine(DebugInternalReactionsLanguageParser.RoutineContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineOverrideImportPath}.
	 * @param ctx the parse tree
	 */
	void enterRoutineOverrideImportPath(DebugInternalReactionsLanguageParser.RoutineOverrideImportPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineOverrideImportPath}.
	 * @param ctx the parse tree
	 */
	void exitRoutineOverrideImportPath(DebugInternalReactionsLanguageParser.RoutineOverrideImportPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineInput}.
	 * @param ctx the parse tree
	 */
	void enterRoutineInput(DebugInternalReactionsLanguageParser.RoutineInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#routineInput}.
	 * @param ctx the parse tree
	 */
	void exitRoutineInput(DebugInternalReactionsLanguageParser.RoutineInputContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchBlock}.
	 * @param ctx the parse tree
	 */
	void enterMatchBlock(DebugInternalReactionsLanguageParser.MatchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchBlock}.
	 * @param ctx the parse tree
	 */
	void exitMatchBlock(DebugInternalReactionsLanguageParser.MatchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchStatement}.
	 * @param ctx the parse tree
	 */
	void enterMatchStatement(DebugInternalReactionsLanguageParser.MatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchStatement}.
	 * @param ctx the parse tree
	 */
	void exitMatchStatement(DebugInternalReactionsLanguageParser.MatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveOrRequireAbscenceOfModelElement}.
	 * @param ctx the parse tree
	 */
	void enterRetrieveOrRequireAbscenceOfModelElement(DebugInternalReactionsLanguageParser.RetrieveOrRequireAbscenceOfModelElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveOrRequireAbscenceOfModelElement}.
	 * @param ctx the parse tree
	 */
	void exitRetrieveOrRequireAbscenceOfModelElement(DebugInternalReactionsLanguageParser.RetrieveOrRequireAbscenceOfModelElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#requireAbscenceOfModelElement}.
	 * @param ctx the parse tree
	 */
	void enterRequireAbscenceOfModelElement(DebugInternalReactionsLanguageParser.RequireAbscenceOfModelElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#requireAbscenceOfModelElement}.
	 * @param ctx the parse tree
	 */
	void exitRequireAbscenceOfModelElement(DebugInternalReactionsLanguageParser.RequireAbscenceOfModelElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveModelElement}.
	 * @param ctx the parse tree
	 */
	void enterRetrieveModelElement(DebugInternalReactionsLanguageParser.RetrieveModelElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveModelElement}.
	 * @param ctx the parse tree
	 */
	void exitRetrieveModelElement(DebugInternalReactionsLanguageParser.RetrieveModelElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveModelElementTypeStatement}.
	 * @param ctx the parse tree
	 */
	void enterRetrieveModelElementTypeStatement(DebugInternalReactionsLanguageParser.RetrieveModelElementTypeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#retrieveModelElementTypeStatement}.
	 * @param ctx the parse tree
	 */
	void exitRetrieveModelElementTypeStatement(DebugInternalReactionsLanguageParser.RetrieveModelElementTypeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchCheckStatement}.
	 * @param ctx the parse tree
	 */
	void enterMatchCheckStatement(DebugInternalReactionsLanguageParser.MatchCheckStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#matchCheckStatement}.
	 * @param ctx the parse tree
	 */
	void exitMatchCheckStatement(DebugInternalReactionsLanguageParser.MatchCheckStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#createBlock}.
	 * @param ctx the parse tree
	 */
	void enterCreateBlock(DebugInternalReactionsLanguageParser.CreateBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#createBlock}.
	 * @param ctx the parse tree
	 */
	void exitCreateBlock(DebugInternalReactionsLanguageParser.CreateBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateStatement(DebugInternalReactionsLanguageParser.CreateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateStatement(DebugInternalReactionsLanguageParser.CreateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#updateBlock}.
	 * @param ctx the parse tree
	 */
	void enterUpdateBlock(DebugInternalReactionsLanguageParser.UpdateBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#updateBlock}.
	 * @param ctx the parse tree
	 */
	void exitUpdateBlock(DebugInternalReactionsLanguageParser.UpdateBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassReference}.
	 * @param ctx the parse tree
	 */
	void enterMetaclassReference(DebugInternalReactionsLanguageParser.MetaclassReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassReference}.
	 * @param ctx the parse tree
	 */
	void exitMetaclassReference(DebugInternalReactionsLanguageParser.MetaclassReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#unnamedMetaclassReference}.
	 * @param ctx the parse tree
	 */
	void enterUnnamedMetaclassReference(DebugInternalReactionsLanguageParser.UnnamedMetaclassReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#unnamedMetaclassReference}.
	 * @param ctx the parse tree
	 */
	void exitUnnamedMetaclassReference(DebugInternalReactionsLanguageParser.UnnamedMetaclassReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#namedMetaclassReference}.
	 * @param ctx the parse tree
	 */
	void enterNamedMetaclassReference(DebugInternalReactionsLanguageParser.NamedMetaclassReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#namedMetaclassReference}.
	 * @param ctx the parse tree
	 */
	void exitNamedMetaclassReference(DebugInternalReactionsLanguageParser.NamedMetaclassReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#namedJavaElementReference}.
	 * @param ctx the parse tree
	 */
	void enterNamedJavaElementReference(DebugInternalReactionsLanguageParser.NamedJavaElementReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#namedJavaElementReference}.
	 * @param ctx the parse tree
	 */
	void exitNamedJavaElementReference(DebugInternalReactionsLanguageParser.NamedJavaElementReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassEAttributeReference}.
	 * @param ctx the parse tree
	 */
	void enterMetaclassEAttributeReference(DebugInternalReactionsLanguageParser.MetaclassEAttributeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassEAttributeReference}.
	 * @param ctx the parse tree
	 */
	void exitMetaclassEAttributeReference(DebugInternalReactionsLanguageParser.MetaclassEAttributeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassEReferenceReference}.
	 * @param ctx the parse tree
	 */
	void enterMetaclassEReferenceReference(DebugInternalReactionsLanguageParser.MetaclassEReferenceReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#metaclassEReferenceReference}.
	 * @param ctx the parse tree
	 */
	void exitMetaclassEReferenceReference(DebugInternalReactionsLanguageParser.MetaclassEReferenceReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpression}.
	 * @param ctx the parse tree
	 */
	void enterXExpression(DebugInternalReactionsLanguageParser.XExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpression}.
	 * @param ctx the parse tree
	 */
	void exitXExpression(DebugInternalReactionsLanguageParser.XExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAssignment}.
	 * @param ctx the parse tree
	 */
	void enterXAssignment(DebugInternalReactionsLanguageParser.XAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAssignment}.
	 * @param ctx the parse tree
	 */
	void exitXAssignment(DebugInternalReactionsLanguageParser.XAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opSingleAssign}.
	 * @param ctx the parse tree
	 */
	void enterOpSingleAssign(DebugInternalReactionsLanguageParser.OpSingleAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opSingleAssign}.
	 * @param ctx the parse tree
	 */
	void exitOpSingleAssign(DebugInternalReactionsLanguageParser.OpSingleAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opMultiAssign}.
	 * @param ctx the parse tree
	 */
	void enterOpMultiAssign(DebugInternalReactionsLanguageParser.OpMultiAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opMultiAssign}.
	 * @param ctx the parse tree
	 */
	void exitOpMultiAssign(DebugInternalReactionsLanguageParser.OpMultiAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterXOrExpression(DebugInternalReactionsLanguageParser.XOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitXOrExpression(DebugInternalReactionsLanguageParser.XOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opOr}.
	 * @param ctx the parse tree
	 */
	void enterOpOr(DebugInternalReactionsLanguageParser.OpOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opOr}.
	 * @param ctx the parse tree
	 */
	void exitOpOr(DebugInternalReactionsLanguageParser.OpOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterXAndExpression(DebugInternalReactionsLanguageParser.XAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitXAndExpression(DebugInternalReactionsLanguageParser.XAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opAnd}.
	 * @param ctx the parse tree
	 */
	void enterOpAnd(DebugInternalReactionsLanguageParser.OpAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opAnd}.
	 * @param ctx the parse tree
	 */
	void exitOpAnd(DebugInternalReactionsLanguageParser.OpAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xEqualityExpression}.
	 * @param ctx the parse tree
	 */
	void enterXEqualityExpression(DebugInternalReactionsLanguageParser.XEqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xEqualityExpression}.
	 * @param ctx the parse tree
	 */
	void exitXEqualityExpression(DebugInternalReactionsLanguageParser.XEqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opEquality}.
	 * @param ctx the parse tree
	 */
	void enterOpEquality(DebugInternalReactionsLanguageParser.OpEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opEquality}.
	 * @param ctx the parse tree
	 */
	void exitOpEquality(DebugInternalReactionsLanguageParser.OpEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xRelationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterXRelationalExpression(DebugInternalReactionsLanguageParser.XRelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xRelationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitXRelationalExpression(DebugInternalReactionsLanguageParser.XRelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opCompare}.
	 * @param ctx the parse tree
	 */
	void enterOpCompare(DebugInternalReactionsLanguageParser.OpCompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opCompare}.
	 * @param ctx the parse tree
	 */
	void exitOpCompare(DebugInternalReactionsLanguageParser.OpCompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xOtherOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterXOtherOperatorExpression(DebugInternalReactionsLanguageParser.XOtherOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xOtherOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitXOtherOperatorExpression(DebugInternalReactionsLanguageParser.XOtherOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opOther}.
	 * @param ctx the parse tree
	 */
	void enterOpOther(DebugInternalReactionsLanguageParser.OpOtherContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opOther}.
	 * @param ctx the parse tree
	 */
	void exitOpOther(DebugInternalReactionsLanguageParser.OpOtherContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterXAdditiveExpression(DebugInternalReactionsLanguageParser.XAdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xAdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitXAdditiveExpression(DebugInternalReactionsLanguageParser.XAdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opAdd}.
	 * @param ctx the parse tree
	 */
	void enterOpAdd(DebugInternalReactionsLanguageParser.OpAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opAdd}.
	 * @param ctx the parse tree
	 */
	void exitOpAdd(DebugInternalReactionsLanguageParser.OpAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xMultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterXMultiplicativeExpression(DebugInternalReactionsLanguageParser.XMultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xMultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitXMultiplicativeExpression(DebugInternalReactionsLanguageParser.XMultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opMulti}.
	 * @param ctx the parse tree
	 */
	void enterOpMulti(DebugInternalReactionsLanguageParser.OpMultiContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opMulti}.
	 * @param ctx the parse tree
	 */
	void exitOpMulti(DebugInternalReactionsLanguageParser.OpMultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterXUnaryOperation(DebugInternalReactionsLanguageParser.XUnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitXUnaryOperation(DebugInternalReactionsLanguageParser.XUnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opUnary}.
	 * @param ctx the parse tree
	 */
	void enterOpUnary(DebugInternalReactionsLanguageParser.OpUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opUnary}.
	 * @param ctx the parse tree
	 */
	void exitOpUnary(DebugInternalReactionsLanguageParser.OpUnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCastedExpression}.
	 * @param ctx the parse tree
	 */
	void enterXCastedExpression(DebugInternalReactionsLanguageParser.XCastedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCastedExpression}.
	 * @param ctx the parse tree
	 */
	void exitXCastedExpression(DebugInternalReactionsLanguageParser.XCastedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xPostfixOperation}.
	 * @param ctx the parse tree
	 */
	void enterXPostfixOperation(DebugInternalReactionsLanguageParser.XPostfixOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xPostfixOperation}.
	 * @param ctx the parse tree
	 */
	void exitXPostfixOperation(DebugInternalReactionsLanguageParser.XPostfixOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#opPostfix}.
	 * @param ctx the parse tree
	 */
	void enterOpPostfix(DebugInternalReactionsLanguageParser.OpPostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#opPostfix}.
	 * @param ctx the parse tree
	 */
	void exitOpPostfix(DebugInternalReactionsLanguageParser.OpPostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xMemberFeatureCall}.
	 * @param ctx the parse tree
	 */
	void enterXMemberFeatureCall(DebugInternalReactionsLanguageParser.XMemberFeatureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xMemberFeatureCall}.
	 * @param ctx the parse tree
	 */
	void exitXMemberFeatureCall(DebugInternalReactionsLanguageParser.XMemberFeatureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xPrimaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterXPrimaryExpression(DebugInternalReactionsLanguageParser.XPrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xPrimaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitXPrimaryExpression(DebugInternalReactionsLanguageParser.XPrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXLiteral(DebugInternalReactionsLanguageParser.XLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXLiteral(DebugInternalReactionsLanguageParser.XLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCollectionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXCollectionLiteral(DebugInternalReactionsLanguageParser.XCollectionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCollectionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXCollectionLiteral(DebugInternalReactionsLanguageParser.XCollectionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSetLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXSetLiteral(DebugInternalReactionsLanguageParser.XSetLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSetLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXSetLiteral(DebugInternalReactionsLanguageParser.XSetLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xListLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXListLiteral(DebugInternalReactionsLanguageParser.XListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xListLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXListLiteral(DebugInternalReactionsLanguageParser.XListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xClosure}.
	 * @param ctx the parse tree
	 */
	void enterXClosure(DebugInternalReactionsLanguageParser.XClosureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xClosure}.
	 * @param ctx the parse tree
	 */
	void exitXClosure(DebugInternalReactionsLanguageParser.XClosureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpressionInClosure}.
	 * @param ctx the parse tree
	 */
	void enterXExpressionInClosure(DebugInternalReactionsLanguageParser.XExpressionInClosureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpressionInClosure}.
	 * @param ctx the parse tree
	 */
	void exitXExpressionInClosure(DebugInternalReactionsLanguageParser.XExpressionInClosureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xShortClosure}.
	 * @param ctx the parse tree
	 */
	void enterXShortClosure(DebugInternalReactionsLanguageParser.XShortClosureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xShortClosure}.
	 * @param ctx the parse tree
	 */
	void exitXShortClosure(DebugInternalReactionsLanguageParser.XShortClosureContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterXParenthesizedExpression(DebugInternalReactionsLanguageParser.XParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitXParenthesizedExpression(DebugInternalReactionsLanguageParser.XParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xIfExpression}.
	 * @param ctx the parse tree
	 */
	void enterXIfExpression(DebugInternalReactionsLanguageParser.XIfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xIfExpression}.
	 * @param ctx the parse tree
	 */
	void exitXIfExpression(DebugInternalReactionsLanguageParser.XIfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSwitchExpression}.
	 * @param ctx the parse tree
	 */
	void enterXSwitchExpression(DebugInternalReactionsLanguageParser.XSwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSwitchExpression}.
	 * @param ctx the parse tree
	 */
	void exitXSwitchExpression(DebugInternalReactionsLanguageParser.XSwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCasePart}.
	 * @param ctx the parse tree
	 */
	void enterXCasePart(DebugInternalReactionsLanguageParser.XCasePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCasePart}.
	 * @param ctx the parse tree
	 */
	void exitXCasePart(DebugInternalReactionsLanguageParser.XCasePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xForLoopExpression}.
	 * @param ctx the parse tree
	 */
	void enterXForLoopExpression(DebugInternalReactionsLanguageParser.XForLoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xForLoopExpression}.
	 * @param ctx the parse tree
	 */
	void exitXForLoopExpression(DebugInternalReactionsLanguageParser.XForLoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBasicForLoopExpression}.
	 * @param ctx the parse tree
	 */
	void enterXBasicForLoopExpression(DebugInternalReactionsLanguageParser.XBasicForLoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBasicForLoopExpression}.
	 * @param ctx the parse tree
	 */
	void exitXBasicForLoopExpression(DebugInternalReactionsLanguageParser.XBasicForLoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xWhileExpression}.
	 * @param ctx the parse tree
	 */
	void enterXWhileExpression(DebugInternalReactionsLanguageParser.XWhileExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xWhileExpression}.
	 * @param ctx the parse tree
	 */
	void exitXWhileExpression(DebugInternalReactionsLanguageParser.XWhileExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xDoWhileExpression}.
	 * @param ctx the parse tree
	 */
	void enterXDoWhileExpression(DebugInternalReactionsLanguageParser.XDoWhileExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xDoWhileExpression}.
	 * @param ctx the parse tree
	 */
	void exitXDoWhileExpression(DebugInternalReactionsLanguageParser.XDoWhileExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBlockExpression}.
	 * @param ctx the parse tree
	 */
	void enterXBlockExpression(DebugInternalReactionsLanguageParser.XBlockExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBlockExpression}.
	 * @param ctx the parse tree
	 */
	void exitXBlockExpression(DebugInternalReactionsLanguageParser.XBlockExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpressionOrVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterXExpressionOrVarDeclaration(DebugInternalReactionsLanguageParser.XExpressionOrVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xExpressionOrVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitXExpressionOrVarDeclaration(DebugInternalReactionsLanguageParser.XExpressionOrVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterXVariableDeclaration(DebugInternalReactionsLanguageParser.XVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitXVariableDeclaration(DebugInternalReactionsLanguageParser.XVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterJvmFormalParameter(DebugInternalReactionsLanguageParser.JvmFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitJvmFormalParameter(DebugInternalReactionsLanguageParser.JvmFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#fullJvmFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFullJvmFormalParameter(DebugInternalReactionsLanguageParser.FullJvmFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#fullJvmFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFullJvmFormalParameter(DebugInternalReactionsLanguageParser.FullJvmFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xFeatureCall}.
	 * @param ctx the parse tree
	 */
	void enterXFeatureCall(DebugInternalReactionsLanguageParser.XFeatureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xFeatureCall}.
	 * @param ctx the parse tree
	 */
	void exitXFeatureCall(DebugInternalReactionsLanguageParser.XFeatureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#featureCallID}.
	 * @param ctx the parse tree
	 */
	void enterFeatureCallID(DebugInternalReactionsLanguageParser.FeatureCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#featureCallID}.
	 * @param ctx the parse tree
	 */
	void exitFeatureCallID(DebugInternalReactionsLanguageParser.FeatureCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#idOrSuper}.
	 * @param ctx the parse tree
	 */
	void enterIdOrSuper(DebugInternalReactionsLanguageParser.IdOrSuperContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#idOrSuper}.
	 * @param ctx the parse tree
	 */
	void exitIdOrSuper(DebugInternalReactionsLanguageParser.IdOrSuperContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xConstructorCall}.
	 * @param ctx the parse tree
	 */
	void enterXConstructorCall(DebugInternalReactionsLanguageParser.XConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xConstructorCall}.
	 * @param ctx the parse tree
	 */
	void exitXConstructorCall(DebugInternalReactionsLanguageParser.XConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBooleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXBooleanLiteral(DebugInternalReactionsLanguageParser.XBooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xBooleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXBooleanLiteral(DebugInternalReactionsLanguageParser.XBooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xNullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXNullLiteral(DebugInternalReactionsLanguageParser.XNullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xNullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXNullLiteral(DebugInternalReactionsLanguageParser.XNullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xNumberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXNumberLiteral(DebugInternalReactionsLanguageParser.XNumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xNumberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXNumberLiteral(DebugInternalReactionsLanguageParser.XNumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXStringLiteral(DebugInternalReactionsLanguageParser.XStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXStringLiteral(DebugInternalReactionsLanguageParser.XStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xTypeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterXTypeLiteral(DebugInternalReactionsLanguageParser.XTypeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xTypeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitXTypeLiteral(DebugInternalReactionsLanguageParser.XTypeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xThrowExpression}.
	 * @param ctx the parse tree
	 */
	void enterXThrowExpression(DebugInternalReactionsLanguageParser.XThrowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xThrowExpression}.
	 * @param ctx the parse tree
	 */
	void exitXThrowExpression(DebugInternalReactionsLanguageParser.XThrowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xReturnExpression}.
	 * @param ctx the parse tree
	 */
	void enterXReturnExpression(DebugInternalReactionsLanguageParser.XReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xReturnExpression}.
	 * @param ctx the parse tree
	 */
	void exitXReturnExpression(DebugInternalReactionsLanguageParser.XReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xTryCatchFinallyExpression}.
	 * @param ctx the parse tree
	 */
	void enterXTryCatchFinallyExpression(DebugInternalReactionsLanguageParser.XTryCatchFinallyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xTryCatchFinallyExpression}.
	 * @param ctx the parse tree
	 */
	void exitXTryCatchFinallyExpression(DebugInternalReactionsLanguageParser.XTryCatchFinallyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSynchronizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterXSynchronizedExpression(DebugInternalReactionsLanguageParser.XSynchronizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xSynchronizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitXSynchronizedExpression(DebugInternalReactionsLanguageParser.XSynchronizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCatchClause}.
	 * @param ctx the parse tree
	 */
	void enterXCatchClause(DebugInternalReactionsLanguageParser.XCatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xCatchClause}.
	 * @param ctx the parse tree
	 */
	void exitXCatchClause(DebugInternalReactionsLanguageParser.XCatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(DebugInternalReactionsLanguageParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(DebugInternalReactionsLanguageParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DebugInternalReactionsLanguageParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DebugInternalReactionsLanguageParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmTypeReference}.
	 * @param ctx the parse tree
	 */
	void enterJvmTypeReference(DebugInternalReactionsLanguageParser.JvmTypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmTypeReference}.
	 * @param ctx the parse tree
	 */
	void exitJvmTypeReference(DebugInternalReactionsLanguageParser.JvmTypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#arrayBrackets}.
	 * @param ctx the parse tree
	 */
	void enterArrayBrackets(DebugInternalReactionsLanguageParser.ArrayBracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#arrayBrackets}.
	 * @param ctx the parse tree
	 */
	void exitArrayBrackets(DebugInternalReactionsLanguageParser.ArrayBracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xFunctionTypeRef}.
	 * @param ctx the parse tree
	 */
	void enterXFunctionTypeRef(DebugInternalReactionsLanguageParser.XFunctionTypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xFunctionTypeRef}.
	 * @param ctx the parse tree
	 */
	void exitXFunctionTypeRef(DebugInternalReactionsLanguageParser.XFunctionTypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmParameterizedTypeReference}.
	 * @param ctx the parse tree
	 */
	void enterJvmParameterizedTypeReference(DebugInternalReactionsLanguageParser.JvmParameterizedTypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmParameterizedTypeReference}.
	 * @param ctx the parse tree
	 */
	void exitJvmParameterizedTypeReference(DebugInternalReactionsLanguageParser.JvmParameterizedTypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmArgumentTypeReference}.
	 * @param ctx the parse tree
	 */
	void enterJvmArgumentTypeReference(DebugInternalReactionsLanguageParser.JvmArgumentTypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmArgumentTypeReference}.
	 * @param ctx the parse tree
	 */
	void exitJvmArgumentTypeReference(DebugInternalReactionsLanguageParser.JvmArgumentTypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmWildcardTypeReference}.
	 * @param ctx the parse tree
	 */
	void enterJvmWildcardTypeReference(DebugInternalReactionsLanguageParser.JvmWildcardTypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmWildcardTypeReference}.
	 * @param ctx the parse tree
	 */
	void exitJvmWildcardTypeReference(DebugInternalReactionsLanguageParser.JvmWildcardTypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmUpperBound}.
	 * @param ctx the parse tree
	 */
	void enterJvmUpperBound(DebugInternalReactionsLanguageParser.JvmUpperBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmUpperBound}.
	 * @param ctx the parse tree
	 */
	void exitJvmUpperBound(DebugInternalReactionsLanguageParser.JvmUpperBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmUpperBoundAnded}.
	 * @param ctx the parse tree
	 */
	void enterJvmUpperBoundAnded(DebugInternalReactionsLanguageParser.JvmUpperBoundAndedContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmUpperBoundAnded}.
	 * @param ctx the parse tree
	 */
	void exitJvmUpperBoundAnded(DebugInternalReactionsLanguageParser.JvmUpperBoundAndedContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmLowerBound}.
	 * @param ctx the parse tree
	 */
	void enterJvmLowerBound(DebugInternalReactionsLanguageParser.JvmLowerBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmLowerBound}.
	 * @param ctx the parse tree
	 */
	void exitJvmLowerBound(DebugInternalReactionsLanguageParser.JvmLowerBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmLowerBoundAnded}.
	 * @param ctx the parse tree
	 */
	void enterJvmLowerBoundAnded(DebugInternalReactionsLanguageParser.JvmLowerBoundAndedContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#jvmLowerBoundAnded}.
	 * @param ctx the parse tree
	 */
	void exitJvmLowerBoundAnded(DebugInternalReactionsLanguageParser.JvmLowerBoundAndedContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedNameWithWildcard}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameWithWildcard(DebugInternalReactionsLanguageParser.QualifiedNameWithWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedNameWithWildcard}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameWithWildcard(DebugInternalReactionsLanguageParser.QualifiedNameWithWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#validID}.
	 * @param ctx the parse tree
	 */
	void enterValidID(DebugInternalReactionsLanguageParser.ValidIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#validID}.
	 * @param ctx the parse tree
	 */
	void exitValidID(DebugInternalReactionsLanguageParser.ValidIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xImportSection}.
	 * @param ctx the parse tree
	 */
	void enterXImportSection(DebugInternalReactionsLanguageParser.XImportSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xImportSection}.
	 * @param ctx the parse tree
	 */
	void exitXImportSection(DebugInternalReactionsLanguageParser.XImportSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#xImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterXImportDeclaration(DebugInternalReactionsLanguageParser.XImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#xImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitXImportDeclaration(DebugInternalReactionsLanguageParser.XImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedNameInStaticImport}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameInStaticImport(DebugInternalReactionsLanguageParser.QualifiedNameInStaticImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link DebugInternalReactionsLanguageParser#qualifiedNameInStaticImport}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameInStaticImport(DebugInternalReactionsLanguageParser.QualifiedNameInStaticImportContext ctx);
}