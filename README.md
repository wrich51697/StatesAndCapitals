# StatesAndCapitals User Manual

## Introduction

The `StatesAndCapitals` project is a simple Java application that stores a list of U.S. states and their capitals in a 
HashMap.
The application allows users to query the capital of any given state and displays all states with their
capitals.
The project includes detailed logging and unit tests to ensure the correct functionality.

## Requirements

- Java Development Kit (JDK) 17 or higher
- Maven (for dependency management and build automation)
- IntelliJ IDEA (optional, but recommended for ease of development)

## Project Structure

        StatesAndCapitals/
        ├── src/
        │   ├── main/
        │   │   └── java/
        │   │       └── org/
        │   │           └── example/
        │   │               └── StatesAndCapitals.java
        │   ├── resources/
        │   │   └── logging.properties
        │   └── test/
        │       └── java/
        │           └── org/
        │               └── example/
        │                   └── StatesAndCapitalsTest.java
        ├── logs/  (Generated after running the application)
        │   └── states_and_capitals.log
        ├── pom.xml
        └── User_Manual.md

## Setting Up the Project

### Prerequisites

1. **Install JDK 17:**
    - Download and install JDK 17 from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or [OpenJDK](https://openjdk.java.net/).

2. **Install Maven:**
    - Follow the instructions on the [Maven website](https://maven.apache.org/install.html) to install Maven.

3. **Install IntelliJ IDEA (Optional):**
    - Download and install IntelliJ IDEA from the [JetBrains website](https://www.jetbrains.com/idea/download/).

### Cloning the Repository

Clone the project repository to your local machine:

```shell
git clone <repository-url>
cd StatesAndCapitals
```
## Building the Project
Build the project using Maven:

```shell
mvn clean install
```
This command will compile the project and download all necessary dependencies.

## Running the Application
From IntelliJ IDEA
1. Open the Project:

    - Open IntelliJ IDEA and select Open or Import.
    - Navigate to the project directory and select pom.xml.

2. Run the Main Class:

    - Navigate to src/main/java/org/example/StatesAndCapitals.java.
    - Right-click on the StatesAndCapitals class and select Run 'StatesAndCapitals.main()'.

## From the Command Line
Run the application using Maven:

``` shell
mvn exec:java -Dexec.mainClass="org.example.StatesAndCapitals"
```

## Using the Application
1. Querying a State's Capital:

    - When prompted, enter the name of a U.S. state.
    - The application will display the capital of the state if it exists in the database.

2. Displaying All States and Capitals:

    - After querying a state's capital, the application will display a list of all states and their capitals.

## Logging
Logs are generated and stored in the logs' directory. The log configuration is defined in the `logging.properties` file.

## Sample Log Entries

``` shell
INFO: Initializing states and capitals map
INFO: States and capitals map initialized successfully
INFO: Fetching capital for state: Alabama
INFO: Found capital for state Alabama: Montgomery
WARNING: No such state found: Invalidstate
```

## Running Unit Tests

### From IntelliJ IDEA

1. Open the Test Class:

    - Navigate to `src/test/java/org/example/StatesAndCapitalsTest.java`.

2. Run the Tests:

    - Right-click on the `StatesAndCapitalsTest` class and select `Run 'StatesAndCapitalsTest'`.

### From the Command Line {id="from-the-command-line_1"}
Run the tests using Maven:

``` shell
mvn test
```

## Troubleshooting

### Issue: Tests are failing with a "package org.junit.jupiter.api does not exist" error.
Solution: Ensure that the JUnit dependencies are correctly defined in your pom.xml file:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

### Issue: Logging configuration errors or logs are not being generated.
Solution: Ensure the logs directory exists in your project root:

```Shell
mkdir logs
```
Also, check that the logging.properties file is correctly placed in the src/main/resources directory.

### Issue: Maven build fails due to missing dependencies.
Solution: Run the following command to update Maven dependencies:

```shell
mvn clean install
```

## Conclusion
The StatesAndCapitals project is a simple yet functional Java application with comprehensive logging and unit testing.
By following the steps outlined in this user manual, you can set up, build, run, and test the application effectively.
If you encounter any issues or have any questions, please refer to the provided code files in the project directory.
