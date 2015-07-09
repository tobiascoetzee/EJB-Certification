# EJB-WAR File Assignment
A small project to demonstrate using Maven to setup a simple WAR file that contains a Stateless bean and Servlet that consumes the bean.

## Running the project
You can run and test the project in either a container like Glassfish or directly with the Tomee plugin.

###To run it in Glassfish:
1. `mvn package`
2. Take the generated ejbweb.war file and deploy it in Glassfish
3. After the server is started and the WAR is deployed browse to http://localhost:8080/ejbweb/hello

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started browse to http://localhost:8080/ejbweb/hello