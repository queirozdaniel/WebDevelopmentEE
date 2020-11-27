package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.model.Opcao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named("form")
@RequestScoped
public class FormBean {

    private Integer numeroInteiro;
    private Double numeroDecimal;
    private Character caracter;
    private Date data;
    private Opcao opcao;

    public String processar(){
        System.out.println("Número inteiro: " + numeroInteiro);
        System.out.println("Número decimal: " + numeroDecimal);
        System.out.println("Caractere: "+ caracter);
        System.out.println("Data: " + data);
        System.out.println("Opção: " + opcao);

        return "result";
    }

    public Integer getNumeroInteiro() {
        return numeroInteiro;
    }

    public void setNumeroInteiro(Integer numeroInteiro) {
        this.numeroInteiro = numeroInteiro;
    }

    public Double getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(Double numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }
}
