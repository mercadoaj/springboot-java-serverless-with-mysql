# Serverless Spring Boot example
SpringBoot Basic CRUD with Serverless

The application can be deployed in an AWS account using the [Serverless Framework](https://github.com/serverless/serverless). The `serverless.yml` file in the root folder contains the application definition

## Installation
To build and install the sample application you will need:
1. Gradle
2. Java 11
3. Serverless Framework
4. Mysql database

Update the application.properties and let it point to your database. The schema can be derived from the entity file in the src.
```
spring.datasource.url= jdbc:mysql://ajdb.c6rfecclsu5u.ap-southeast-1.rds.amazonaws.com:3306/db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true
spring.datasource.username= admin
spring.datasource.password= password
```

In a shell, navigate to the sample's folder and use maven to build a deployable jar.
```
./gradlew build
```

This command should generate a `springboot-serverless-with-mysql.zip` in the `build/distributions` folder. Now that we have generated the jar file, we can use the SLS CLI to package the template for deployment, deploy it, and version control it in S3.

If you already [set up AWS credentials](https://serverless.com/framework/docs/providers/aws/guide/credentials/), run the following command from the sample's folder:

```
$ serverless deploy
```
'sls' command works too but please note that it has some issues with powershell. https://github.com/serverless/serverless/issues/8293.


Once the deployment is complete you'll get information like this in the terminal:

  ![ScreenShot](/docs/endpoints.PNG)

```
$ serverless remove
```