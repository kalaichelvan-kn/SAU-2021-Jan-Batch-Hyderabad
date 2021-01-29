# SAU-2021-Jan-Batch-Hyderabad

## Sonarqube - kalai.chelvan@accolitedigital.com

### mvn command after generating project token

        mvn sonar:sonar -Dsonar.projectKey=auspringmvc -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d69d1579beecb0f05c630d09e0ae530098849102

After analyzing the project most of the bugs and code smells occured due to 
1. unused imports -> remove it
2. Repeated codes -> create a static single varaible
3. Return type should be interface not implementation class

### screenshots

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/SonarQube/cmd.PNG)
![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/SonarQube/s1.PNG)
![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/SonarQube/s2.PNG)
![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/SonarQube/s3.PNG)
![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/JCQ%20-%20Forenoon/SonarQube/s4.PNG)

## end