package com.danielqueiroz.webdevelopmentee.bean.ejb;


import com.danielqueiroz.webdevelopmentee.ejb.ItensSingletonBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("formItemS")
@RequestScoped
public class FormItemSingletonBean implements Serializable {

    //@EJB
    private ItensSingletonBean itensSingletonBean;

    public List<String> getItens(){
        return itensSingletonBean.getItens();
    }

}
