# java-restassured-api-testing
This project is an example of API testing. It tests the project -
https://github.com/Warrfie/secret_trainer
In order to launch this app download it and in the root folder execute next command:
`docker compose -f docker.yaml up -d`

And test can be executed via next command:
`mvn test`

To generate report use this command:
`mvn site`

Then open `target/site/surefire-report.html` file.