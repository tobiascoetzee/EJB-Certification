package com.tobias.listener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;
import java.util.logging.Logger;

@MessageDriven(name="DemoTopic",
        messageListenerInterface = MessageListener.class,
        activationConfig = {
        @ActivationConfigProperty(propertyValue = "javax.jms.Topic",propertyName = "destinationType"),
        @ActivationConfigProperty(propertyValue = "Dups-ok-acknowledge",propertyName = "acknowledgeMode"),
        @ActivationConfigProperty(propertyValue = "Baboon = true", propertyName = "messageSelector")
})
public class ListenerBean implements MessageListener {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public ListenerBean(){
        logger.info("I are constructed!");
    }

    @PostConstruct
    public void initialize(){
        logger.info("I are initialized!");
    }

    @PreDestroy
    public void remove(){
        logger.info("********* I are removed *********");
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;

        try {
            logger.info(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
