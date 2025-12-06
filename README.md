# simple-app

All puzzles from: https://adventofcode.com/

Minimal Maven Java project (Java 21) created for Advent of Code.

Build and run (PowerShell):

```powershell
# show maven version
mvn -v

# build package (skip tests to speed up):
mvn -B -DskipTests package

# run tests:
mvn test

# run the app (after package):
java -cp target/simple-app-1.0-SNAPSHOT.jar com.example.App
```

Notes:
- The project uses JUnit 5 for tests.
- Source and tests are under `src/main/java` and `src/test/java` respectively.
