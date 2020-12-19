package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Despesa;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/SoftTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    }, mappedName = "java:/jms/topic/SoftTopic"
)
public class TopicReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            Despesa despesa = (Despesa) objectMessage.getObject();
            System.out.println(despesa);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
