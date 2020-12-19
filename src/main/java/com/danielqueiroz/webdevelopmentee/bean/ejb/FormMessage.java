package com.danielqueiroz.webdevelopmentee.bean.ejb;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import java.io.Serializable;

@Named("formMessage")
@RequestScoped
public class FormMessage implements Serializable {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/queue/SoftQueue")
    private Queue queue;

    private String mensagem;

    public String enviar(){
        JMSContext context = connectionFactory.createContext();
        JMSProducer producer = context.createProducer();
        producer.send(queue, mensagem);


        return null;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
