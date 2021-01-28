# Code Quality - Part C

## Common Weakness Enumeration (CWE)

software development weaknesses and Vulnerabilities

1. Creation of Immutable Text Using String Concatenation

    The software creates an immutable text string using string concatenation operations. (inside looping with +=, creates string object for each loop makes performance issues)

        String string = "";
        for(int i=0;i<=100;i++){
            string += "temp";
        }

2. Excessive Index Range Scan for a Data Resource

    software contains an index range scan for a large data table, but the scan can cover a large number of rows, which also leads to performance issues. CISQ recommends a threshold of 1000000 table rows and a threshold of 10 for the index range.

3. Modules with Circular Dependencies

    software contains modules in which one module has references that cycle back to itself, that is there are circular dependencies.

4. Exposed Dangerous Method or Function

    software provides an Applications Programming Interface (API) or similar interface for interaction with external actors, but the interface includes a dangerous method or function that is not properly restricted.

5. Undefined Behavior for Input to API

    The behavior of this function is undefined unless its control parameter is set to a specific value.

