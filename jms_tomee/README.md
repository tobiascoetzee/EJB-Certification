# EJB JMS Tomee Demo
A small project to demonstrate using JMS with Tomee. This projects relates to the Developing Java EE Applications Using Messaging exam topic.

## Running the project
You can run and test the project directly with the Tomee plugin. 

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started you can use any client that can do an HTTP request(curl, Postman, SOAPUI)
3.1 POST http://localhost:8080/jms_tomee/jms/send - With a string in the body to write a message
3.2 GET http://localhost:8080/jms_tomee/jms/receive - Consume the message
3.3 GET http://localhost:8080/jms_tomee/jms/browse - To browse the messages in the queue (Not working 100% currently)