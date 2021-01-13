package com.danielqueiroz.webdevelopmentee.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class IndexBean implements Serializable {

    private int x;

    public String getMessage(){
        return "Mensagem Bean: Bem vindo ao desenvolvimento JavaEnterprise!";
    }

    public String thowException(){
        x = 10 / 0 ;
        return null;
    }

    public int getX() {
        return x;
    }
}
