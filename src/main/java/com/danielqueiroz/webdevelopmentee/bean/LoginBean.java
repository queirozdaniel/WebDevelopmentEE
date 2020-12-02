package com.danielqueiroz.webdevelopmentee.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class LoginBean implements Serializable {

    private String nome;
    private String password;

    public String doLogin(){
        if (nome.equals("ASD") && "123".equals(password))
            return "result";

        FacesMessage message = new FacesMessage("Login incorreto");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);

        return null;
    }

    @PostConstruct
    public void onCreate(){
        System.out.println("Bean Criado");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Bean será destruido");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
