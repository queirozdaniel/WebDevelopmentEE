package com.danielqueiroz.webdevelopmentee.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("formajax")
@RequestScoped
public class FormAjaxBean {

    private Integer texto;

    public Integer getTexto() {
        return texto;
    }

    public void setTexto(Integer texto) {
        this.texto = texto;
    }
}
