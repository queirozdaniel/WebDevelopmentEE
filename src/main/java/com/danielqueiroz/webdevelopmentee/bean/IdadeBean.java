package com.danielqueiroz.webdevelopmentee.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Date;

@Named("idade")
@RequestScoped
public class IdadeBean {

    private String nome;
    private Date dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void validarInicial(FacesContext context, UIComponent component, Object value){
        String s = (String) value;

        if (s != null && !s.startsWith("A")){
            // Só lancará exception se a validação falhar
            FacesMessage msg = new FacesMessage("Não começa com a letra A");
            throw new ValidatorException(msg);
        }

    }
}
