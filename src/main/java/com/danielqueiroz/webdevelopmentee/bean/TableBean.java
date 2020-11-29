package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.model.Despesa;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {

    private List<Despesa> despesas = new ArrayList<>();

    public String inserir() {
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

    public List<Despesa> getDespesas() {
        return despesas;
    }
}
