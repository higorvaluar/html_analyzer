# HtmlAnalyzer - Technical Assessment for Software Development Intern

This project was developed as part of a technical assessment for a **Software Development Intern** position.

#### Developer: Higor Valuar Bailona

## Description

**HtmlAnalyzer** is a Java program designed to analyze the HTML structure of a webpage, given its URL. The program extracts and returns the text content from the deepest HTML tag. In case of multiple text fragments at the deepest level, it returns the first one.

The program also handles the following edge cases:
- **Malformed HTML**: If the HTML structure is invalid, the program outputs "malformed HTML".
- **Connection issues**: If the program fails to fetch the HTML content, it outputs "URL connection error".

## Key Features:
- Analyzes HTML content based on the depth of the tag hierarchy.
- Returns the text content of the deepest HTML tag.
- Handles malformed HTML.
- Gracefully manages connection errors.

## How to Use

1. **Compile the Program**:

   Make sure you're in the directory containing the `HtmlAnalyzer.java` file, and then compile the program using the following command:

   ```bash
   javac HtmlAnalyzer.java


2. **Run the program with a valid URL:**

    Use the following command to execute the program, replacing `<URL>` with the URL of the page you want to analyze:

    ```bash
    java HtmlAnalyzer <URL>
   
### Example
Given the URL `https://www.example.com`, the program will return:

    This domain is for use in illustrative examples in documents. You may use this

### Dependencies
This project was developed using JDK 17 and does not require any external libraries or frameworks. It follows the constraints set out in the technical test and can be compiled and run directly from the command line.

### License
This project was created specifically for a technical assessment and is not intended for other use.


