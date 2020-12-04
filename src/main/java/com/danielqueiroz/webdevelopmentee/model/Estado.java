package com.danielqueiroz.webdevelopmentee.model;

import java.io.Serializable;

public class Estado implements Comparable<Estado>, Serializable {

    private String sigla;
    private String nome;
    private Regiao regiao;

    public Estado(String sigla, String nome, Regiao regiao) {
        this.sigla = sigla;
        this.nome = nome;
        this.regiao = regiao;
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

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public int compareTo(Estado o) {
        return this.sigla.compareTo(o.sigla);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return sigla != null ? sigla.equals(estado.sigla) : estado.sigla == null;
    }

    @Override
    public int hashCode() {
        return sigla != null ? sigla.hashCode() : 0;
    }
}
