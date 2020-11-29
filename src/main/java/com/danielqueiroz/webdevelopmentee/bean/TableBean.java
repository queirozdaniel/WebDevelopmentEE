package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.model.Despesa;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {

    private List<Despesa> despesaList = new ArrayList<>();
    private ListDataModel<Despesa> despesas = new ListDataModel<>(despesaList);

    public TableBean() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Despesa d = new Despesa();
        try {
            d.setData(sdf.parse("15/02/2015"));
            d.setDescricao("Item desconhecido");
            d.setEdit(false);
            d.setValor(129.0);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        despesaList.add(d);
    }

    public String inserir(){
        Despesa despesa = new Despesa();
        despesa.setEdit(true);
        despesaList.add(despesa);
        return "despesas";
    }

    public String editar(Despesa despesa){
        despesa.setEdit(true);
        return null;
    }

    public String gravar(Despesa despesa){
        despesa.setEdit(false);
        return null;
    }

    public String excluir(Despesa despesa){
        despesaList.remove(despesa);
        return null;
    }

    public ListDataModel<Despesa> getDespesas() {
        return despesas;
    }
}
