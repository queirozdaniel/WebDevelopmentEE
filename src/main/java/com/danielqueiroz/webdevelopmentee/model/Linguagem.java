package com.danielqueiroz.webdevelopmentee.model;

import java.util.Arrays;
import java.util.List;

public class Linguagem {

    private Integer id;
    private String nome;

    public static List<Linguagem> LINGUAGENS;

    static {
        LINGUAGENS = Arrays.asList(
          new Linguagem(1, "Java"),
          new Linguagem(2, "Javascript"),
          new Linguagem(3, "Kotlin"),
          new Linguagem(4, "C++")
        );
    }

    public Linguagem(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
