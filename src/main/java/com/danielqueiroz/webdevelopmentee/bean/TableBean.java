package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.model.Despesa;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@ConversationScoped
public class TableBean implements Serializable {

    @Inject
    private Conversation conversation;

    private List<Despesa> despesas = new ArrayList<>();

    @PostConstruct
    public void onCreate(){
        System.out.println("Bean Criado");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Bean será destruido");
    }

    public String inserir() {
        if ( despesas.size() == 0)
            conversation.begin();

        Despesa despesa = new Despesa();
        despesa.setEdit(true);
        despesas.add(despesa);

        return "despesas";
    }

    public String editar(Despesa despesa) {
        despesa.setEdit(true);
        return null;
    }

    public String gravar(Despesa despesa) {
        despesa.setEdit(false);
        return null;
    }

    public String excluir(Despesa despesa) {
        despesas.remove(despesa);
        return null;
    }

    public String limparDespesas(){
        despesas.clear();
        conversation.end();
        return "despesas";
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }
}
