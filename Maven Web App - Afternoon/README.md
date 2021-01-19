# SAU-2021-Jan-Batch-Hyderabad

Maven - Web App - Servlet - kalai.chelvan@accolitedigital.com

- mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DartifactId=auwebapp -Dpackage=com.accolite.au -DGroupId=com.accolite.au -DarchetypeVersion=1.4

<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>3.1.0</version>
  <scope>provided</scope>
</dependency>
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.1</version>
    <scope>provided</scope>
</dependency>

<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
      <port>9090</port>
      <path>/</path>
    </configuration>
</plugin>

- mvn tomcat7:run

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Maven%20Web%20App%20-%20Afternoon/installcmd.PNG)
![sc2](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Maven%20Web%20App%20-%20Afternoon/installpath.PNG)
![sc3](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Maven%20Web%20App%20-%20Afternoon/webappcreate.PNG)
![sc4](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Maven%20Web%20App%20-%20Afternoon/servletcode.PNG)
![sc5](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Maven%20Web%20App%20-%20Afternoon/tomcatrun.PNG)