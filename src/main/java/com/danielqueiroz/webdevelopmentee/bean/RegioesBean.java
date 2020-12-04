package com.danielqueiroz.webdevelopmentee.bean;

import com.danielqueiroz.webdevelopmentee.business.RegiaoProvider;
import com.danielqueiroz.webdevelopmentee.model.Estado;
import com.danielqueiroz.webdevelopmentee.model.Regiao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named("regiao")
@RequestScoped
public class RegioesBean implements Serializable {

    private Collection<Regiao> regioes;
    private Collection<Estado> estados;
    private String siglaRegiao;
    private String siglaEstado;

    @PostConstruct
    public void init() {
        regioes = RegiaoProvider.getRegioes();
        System.out.println(RegiaoProvider.getRegioes().size());
        RegiaoProvider.getRegioes().forEach(regiao -> System.out.println(regiao.getEstados().size()));
    }

    public Collection<Regiao> getRegioes() {
        return regioes;
    }

    public Collection<Estado> getEstados() {
        return estados;
    }

    public void carregarEstados(ValueChangeEvent event) {
        this.estados = RegiaoProvider.getEstadosByRegiao(event.getNewValue().toString());

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
