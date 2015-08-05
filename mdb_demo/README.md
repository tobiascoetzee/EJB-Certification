# EJB MDB Tomee Demo
A small project to demonstrate using MDB with Tomee. This projects relates to the Developing Message-Driven Beans exam topic.

## Running the project
You can run and test the project directly with the Tomee plugin. 

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started you can use any client that can do an HTTP request(curl, Postman, SOAPUI)
3.1 GET http://localhost:8080/mdb_demo/send/hello