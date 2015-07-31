package com.tobiascode.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Enumeration;

@Stateless
@Path(value = "/jms")
public class Controller {
    @Resource(name = "DemoConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "DemoQueue")
    private Queue queue;

    @Path(value = "/send")
    @POST
    public String SendMessage(String words){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            TextMessage textMessage = session.createTextMessage(words);

            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.send(textMessage);

            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "Ok";
    }

    @Path(value = "/browse")
    @GET
    public String BrowseMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            QueueBrowser queueBrowser = session.createBrowser(queue);
            Enumeration messages = queueBrowser.getEnumeration();

            while (messages.hasMoreElements()){
                builder.append("*");
                TextMessage message = (TextMessage)messages.nextElement();
                builder.append(message.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

        builder.append("|");
        return builder.toString();
    }

    @Path(value = "/receive")
    @GET
    public String ReceiveMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();

            MessageConsumer messageConsumer = session.createConsumer(queue);
            TextMessage message = (TextMessage)messageConsumer.receive(100);

            while (message != null){
                builder.append(message.getText());
                message = (TextMessage)messageConsumer.receive(100);
            }

            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        builder.append("|");
        return builder.toString();
    }
}
