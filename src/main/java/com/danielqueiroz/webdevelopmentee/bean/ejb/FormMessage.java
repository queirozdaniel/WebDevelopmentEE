package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.model.Despesa;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.*;
import java.io.Serializable;
import java.util.Date;

@Named("formMessage")
@RequestScoped
public class FormMessage implements Serializable {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/queue/SoftQueue")
    private Queue queue;

    @Resource(mappedName = "java:/jms/topic/SoftTopic")
    private Topic topic;

    private String mensagem;

    public String enviar(){
        JMSContext context = connectionFactory.createContext();
        JMSProducer producer = context.createProducer();
        producer.send(queue, mensagem);

        Despesa despesa = new Despesa(new Date(), "", 0.0, true);
        producer.send(topic, despesa);

        return null;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
