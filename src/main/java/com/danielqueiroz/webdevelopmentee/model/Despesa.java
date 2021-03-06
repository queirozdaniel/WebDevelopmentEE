package com.danielqueiroz.webdevelopmentee.model;

import java.io.Serializable;
import java.util.Date;

public class Despesa implements Serializable {

    private Date data;
    private String descricao;
    private Double valor;
    private boolean edit;

    public Despesa() {
    }

    public Despesa(Date data, String descricao, Double valor, boolean edit) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.edit = edit;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", edit=" + edit +
                '}';
    }
}
