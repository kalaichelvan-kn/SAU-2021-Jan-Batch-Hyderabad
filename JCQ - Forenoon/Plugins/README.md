# SAU-2021-Jan-Batch-Hyderabad

## Sonarqube - kalai.chelvan@accolitedigital.com

### SonarLint - Run SonarLint for project files (on spring mvc project)

After analyzing the project files [ results similar to sonarqube ]
1. unused imports -> remove it
2. Repeated codes -> create a static single varaible
3. Return type should be interface not implementation class

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/Plugins/sl.PNG)

### PMD - Tools -> run PMD -> pre defined -> all (on spring mvc project)

shows most of the results of sonarlint, In addition

1. comment required
2. use concurrentHashMap
3. DataFlow Anomaly
4. Immutable Field

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/Plugins/pmd.PNG)

### checkStyle - used a QAPlug which is a pmd, findbugs and checkstyle Integrated plugin (on spring mvc project)

1. Utility class should not have public/default constructor
2. Reduntant Modifier
3. Hidden Fields
etc

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/Plugins/cs.PNG)

### checkStyle default html output (on jcq initial task)

checkstyle html (pdf) -> https://github.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/tree/main/JCQ%20-%20Forenoon/Plugins/cs.pdf

## end