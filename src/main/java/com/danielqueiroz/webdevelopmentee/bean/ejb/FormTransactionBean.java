package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.MyBean;
import com.danielqueiroz.webdevelopmentee.ejb.MyBeanBMT;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("formT")
@RequestScoped
public class FormTransactionBean {

    @EJB
    private MyBeanBMT myBean;
   // private MyBean myBean;

    public String executar(){
        try {
            myBean.mA();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
