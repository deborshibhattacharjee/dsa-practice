# DSA Practice

A Java workspace for practising data structures and algorithms and preparing for coding interviews. The exercises cover array traversal, distinct values, contiguous runs, and sliding windows. Java source files include problem statements and examples.

## Repository layout

| Path | Contents |
| --- | --- |
| [src/dsa/arrays](src/dsa/arrays) | Array exercises on distinct values, contiguous runs, and related problems |
| [src/interviews/epam](src/interviews/epam) | Java interview exercises |
| [test](test) | Standalone Java test programs |

## Run an example

Use JDK 25. From the repository root, compile and run the second-largest-value test on macOS or Linux:

```sh
./gradlew testClasses
java -cp 'build/classes/java/main:build/classes/java/test' dsa.arrays.SecondLargestTest
```

In Windows PowerShell:

```powershell
.\gradlew.bat testClasses
java -cp 'build/classes/java/main;build/classes/java/test' dsa.arrays.SecondLargestTest
```

The test classes define their own `main` methods. Run the class for the exercise you want to check.
