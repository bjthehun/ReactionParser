# Reaction Parser

Parses Vitruvius reactions and reports syntax errors.
Optionally guesses the correct tokens to correct syntax errors.

## Build

```bash
git clone https://github.com/bjthehun/ReactionParser.git
mvn clean verify
```

## Usage

```bash
java -jar parser/target/tools.vitruv.reactionsparser.parser-0.1.0-SNAPSHOT-all.jar [-gcp | --guess-correct-program] <<pathToReactionsFile>>
```
