package com.tobias.sender;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path(value = "/send")
public class SenderController {
    @Resource(name="DemoTopicFactory")
    TopicConnectionFactory topicConnectionFactory;

    @Resource(name="DemoTopic")
    Topic demoTopic;

    @Path(value = "/hello")
    @GET
    public String sendHelloMessage(){
        try {
            Connection connection = topicConnectionFactory.createTopicConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            TextMessage textMessage = session.createTextMessage("I are Baboon!!");
            textMessage.setBooleanProperty("Baboon", true);

            MessageProducer messageProducer = session.createProducer(demoTopic);
            messageProducer.send(textMessage);

            textMessage = session.createTextMessage("I am Weasel!!");
            textMessage.setBooleanProperty("Baboon", false);

            messageProducer.send(textMessage);

        } catch (JMSException e) {
            e.printStackTrace();
        }

        return "Ok";
    }
}
