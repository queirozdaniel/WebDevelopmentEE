package com.danielqueiroz.webdevelopmentee.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Regiao implements Comparable<Regiao>, Serializable {

    private String sigla;
    private String nome;
    private Set<Estado> estados = new TreeSet<>();

    public Regiao(String nome, String sigla) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regiao regiao = (Regiao) o;

        return sigla != null ? sigla.equals(regiao.sigla) : regiao.sigla == null;
    }

    @Override
    public int hashCode() {
        return sigla != null ? sigla.hashCode() : 0;
    }
}
