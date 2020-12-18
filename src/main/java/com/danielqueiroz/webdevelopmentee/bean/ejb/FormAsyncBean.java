package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.AsyncBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("formAsync")
@SessionScoped
public class FormAsyncBean implements Serializable {

    @EJB
    private AsyncBean itensBean;

    private String mensagem;

    public String executar(){
        itensBean.processar();
        mensagem = "Processamento iniciado...";
        return null;
    }

    public String getMensagem() {
        return mensagem;
    }
}
