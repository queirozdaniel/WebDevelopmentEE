package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.business.RegiaoProvider;
import com.danielqueiroz.webdevelopmentee.model.Estado;
import com.danielqueiroz.webdevelopmentee.model.Regiao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named("regiao")
@SessionScoped
public class RegioesBean implements Serializable {

    private Collection<Regiao> regioes;
    private Collection<Estado> estados;
    private String siglaRegiao;
    private String siglaEstado;

    @PostConstruct
    public void init() {
        regioes = RegiaoProvider.getRegioes();
    }

    public Collection<Regiao> getRegioes() {
        return regioes;
    }

    public Collection<Estado> getEstados() {
        return estados;
    }

    public void carregarEstados(ActionEvent event) {
        this.estados = RegiaoProvider.getEstadosByRegiao(siglaRegiao);
    }

    public String getSiglaRegiao() {
        return siglaRegiao;
    }

    public void setSiglaRegiao(String siglaRegiao) {
        this.siglaRegiao = siglaRegiao;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }
}
