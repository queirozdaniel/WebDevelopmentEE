package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.model.Endereco;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("endereco")
@RequestScoped
public class EnderecoBean {

    private Endereco endereco;

    public EnderecoBean(){
        endereco = new Endereco();
        endereco.setRua("Rua X");
        endereco.setNumero("000");
    }

    public String processar(){
        System.out.println(
                "Rua: " + endereco.getRua() + "\n"
                + "Numero: " + endereco.getNumero()
        );
        return "result";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
