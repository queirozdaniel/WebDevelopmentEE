package com.danielqueiroz.webdevelopmentee.model;

import java.util.Set;
import java.util.TreeSet;

public class Regiao implements Comparable<Regiao>{

    private String sigla;
    private String nome;
    private Set<Estado> estados = new TreeSet<>();

    public Regiao(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public int compareTo(Regiao o) {
        return this.nome.compareTo(o.getNome());
    }
}
