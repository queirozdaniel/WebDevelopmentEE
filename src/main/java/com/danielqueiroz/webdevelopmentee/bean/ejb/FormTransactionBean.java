package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.MyBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("formT")
@RequestScoped
public class FormTransactionBean {

    @EJB
    private MyBean myBean;

    public String executar(){
        myBean.mA();
        return null;
    }

}
