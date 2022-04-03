# Springboot 2.3.x with Java11

###  Documentation

Simple Springboot project featuring:

* springboot 2.3.12.RELEASE
* Gradle 
* using H2 with spring JPA
* Java 11
* REST
* Swagger2 integration

### Run  & Test

* Build : gradlew clean assemble
* Run in Intellij or as bootRun
* api-doc :http://localhost:8080/v2/api-docs
* Samples

HTTP POST http://localhost:8080/postcodes
[{"code":2000,"name":"sydney"},{"code":2010,"name":"surry hills"}]

HTTP GET http://localhost:8080/postcodes/?from=1000&to=5000


