# EJB Transaction Demo
A small project to demonstrate using container and bean transaction management. This projects relates to the Implementing Transactions exam topic.

## Running the project
You can run and test the project directly with the Tomee plugin. 

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started you can use any client that can do an HTTP request(curl, Postman, SOAPUI)
3.1 GET http://localhost:8080/transaction_demo/container/with
3.2 GET http://localhost:8080/transaction_demo/container/without
3.3 GET http://localhost:8080/transaction_demo/bean/commit
3.4 GET http://localhost:8080/transaction_demo/bean/rollback