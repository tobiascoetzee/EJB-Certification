# EJB Session Bean Lifecycle Demo
A small project to demonstrate the different lifecylce callbacks used for session beans. This projects relates to the Advanced Session Bean Concepts exam topic.

## Running the project
You can run and test the project in either a container like Glassfish or directly with the Tomee plugin. For passevation you will need to change the containers settings. Set bulk passivate to zero, frequency to something like 1 second and cache size to 2.

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started browse to http://localhost:8080/sessionbean-lifecycle/stateful.do to see the stateful events.
4. Or browse to http://localhost:8080/sessionbean-lifecycle/stateless.do to see the stateless event.