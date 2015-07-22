# EJB Singleton Bean Demo
A small project to demonstrate creating a singleton bean, the bean lifecylce callbacks and concurrency management. This projects relates to the Singleton Session Bean exam topic.

## Running the project
You can run and test the project in either a container like Glassfish or directly with the Tomee plugin. 

###To run it with Tomee:
1. `mvn package`
2. `mvn tomee:run`
3. After the server is started browse to http://localhost:8080/singleton_bean/servlet1.do or http://localhost:8080/singleton_bean/servlet2.do to see the lifecycle events.
4. Or browse to http://localhost:8080/sessionbean-lifecycle/servlet3.do to see concurrency management in action.