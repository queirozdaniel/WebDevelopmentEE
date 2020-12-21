package com.danielqueiroz.webdevelopmentee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Arrays;
import java.util.List;

// @Singleton
// @Startup // Inicia junto ao servidor
public class ItensSingletonBean {

    private List<String> itens;

    @PostConstruct
    private void init(){
        itens = Arrays.asList("Arroz", "Feijão", "Café", "Macarrão");
        System.out.println("Inicializando itens");
    }

    public List<String> getItens() {
        return itens;
    }
}
