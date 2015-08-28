# EJB Timers Demo
A small project to demonstrate using declarative and programmatic timers in an EJB. This projects relates to the Using Timer Services exam topic.

## Running the project
You can run and test the project directly with the Tomee plugin. 

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started you can use any client that can do an HTTP request(curl, Postman, SOAPUI)
GET http://localhost:8080/ejb_timers/timer/start
GET http://localhost:8080/ejb_timers/timer/stop