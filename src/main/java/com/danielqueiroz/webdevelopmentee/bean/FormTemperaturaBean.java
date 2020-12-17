package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.ejb.TemperatureConverterBean;
import com.danielqueiroz.webdevelopmentee.ejb.TemperatureConverterBeanLocal;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("formTemp")
@RequestScoped
public class FormTemperaturaBean implements Serializable {

    private Double tc;
    private Double tf;

    @EJB
    private TemperatureConverterBeanLocal converter;

    public String convertCelsiusToFahrenheit(){
        this.tf = converter.convertCelsiusToFahrenheit(tc);
        return null;
    }

    @Init
    public Double getTc() {
        return tc;
    }

    public void setTc(Double tc) {
        this.tc = tc;
    }

    public Double getTf() {
        return tf;
    }

    public void setTf(Double tf) {
        this.tf = tf;
    }
}
