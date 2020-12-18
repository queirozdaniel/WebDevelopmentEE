package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.AsyncBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named("formAsync")
@SessionScoped
public class FormAsyncBean implements Serializable {

    @EJB
    private AsyncBean itensBean;

    private String mensagem;

    private Future<Integer> future;

    public String executar(){
        itensBean.processar();
        mensagem = "Processamento iniciado...";
        return null;
    }

    public String executarERetornar(){
        future = itensBean.processarERetornar();
        mensagem = "Processamento iniciado...";
        return null;
    }

    public String verificar(){
        if (!future.isDone()){
            mensagem = "Execução em andamento...";
        } else {
            try {
                mensagem = "Resultado: " + future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getMensagem() {
        return mensagem;
    }
}
