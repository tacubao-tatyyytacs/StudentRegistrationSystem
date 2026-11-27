## Code Review Summary

| # | Review Category | Identified Issues / Observations |
|:-:|:----------------|:---------------------------------|
| 1 | **Naming conventions** | The variable `n` is not descriptive enough. It would be better to use `name`. The parameters `a` and `g` should also be renamed to `age` and `grade`. |
| 2 | **Code formatting** | The code has unnecessary blank lines and inconsistent spacing. The statements should be consistently indented and organized to improve readability. |
| 3 | **Logical errors** | The program allows invalid student information. For example, `add("", -5, 150)` is accepted even though the name is empty, the age is negative, and the grade is above 100. |
| 4 | **Input validation** | There is no validation for student names, ages, or grades. The program should reject empty names, negative ages, and grades outside the valid range of 0–100. |
| 5 | **Exception handling** | There is no exception handling. Although the current code does not directly show an unexpected error, it would benefit from handling possible exceptions when processing student information. |
| 6 | **Duplicate code** | The `add()` method contains several repeated `System.out.println()` statements. These could be simplified using a separate method to display student information. |
| 7 | **Security** | The program accepts input without checking whether it is valid. Although this is a simple program, validating user input helps prevent incorrect or unexpected data from entering the system. |
| 8 | **Maintainability** | The program would be difficult to modify as it grows because it uses separate parameters and only stores student names. Using a `Student` class with `name`, `age`, and `grade` fields would make future modifications easier. |
| 9 | **Data Storage** | The program only stores student names in the ArrayList. The age and grade are displayed but not saved, making it impossible to retrieve the complete student information later. |
| 10 | **Data Integrity** | The program does not ensure that student records are complete and accurate before saving them. This can result in incomplete or unreliable student records. |