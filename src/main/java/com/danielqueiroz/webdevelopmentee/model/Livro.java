package com.danielqueiroz.webdevelopmentee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livro {

    @Id
    private Integer id;
    private String titulo;
    private Integer numPaginas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }
}
