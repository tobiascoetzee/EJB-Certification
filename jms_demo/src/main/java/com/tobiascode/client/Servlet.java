package com.tobiascode.client;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//jms/DemoQueueFactory
//jms/DemoQueue
public class Servlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("I'm starting");

            InitialContext initialContext = new InitialContext();
            QueueConnectionFactory connectionFactory = (QueueConnectionFactory)initialContext.lookup("jms/DemoQueueFactory");
            Queue queue = (Queue)initialContext.lookup("jms/DemoQueue");

            Connection connection = connectionFactory.createQueueConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("JMS Message");

            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.send(textMessage);

            out.println("Message Sent");

            QueueBrowser queueBrowser = session.createBrowser(queue);
            Enumeration enumeration = queueBrowser.getEnumeration();

            out.println("Browsing");
            while (enumeration.hasMoreElements()){
                TextMessage message = (TextMessage)enumeration.nextElement();
                out.println(message.getText());
            }

            connection.start();

            MessageConsumer messageConsumer = session.createConsumer(queue);
            TextMessage message = (TextMessage)messageConsumer.receive(100);

            out.println("Consuming");
            while (message != null){
                out.println(message.getText());
                message = (TextMessage)messageConsumer.receive(100);
            }

            connection.close();

            out.println("I'm done");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

