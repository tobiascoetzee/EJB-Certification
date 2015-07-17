# EJB Async Business Methods Demo
A small project to demonstrate using async methods with session beans. This projects relates to the Advanced Session Bean Concepts exam topic.

## Running the project
You can run and test the project in either a container like Glassfish or directly with the Tomee plugin. The client is a REST service you can hit using something like the curl command, SOAPUI or Postman.

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started you can ping the following resource
3.1 GET http://localhost:8080/async_bean/async/cancel
3.2 GET http://localhost:8080/async_bean/async/none
3.3 GET http://localhost:8080/async_bean/async/value