package com.danielqueiroz.webdevelopmentee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class ItensBean {

    private List<String> itens = new ArrayList<>();

    public void adicionarItem(String item){
        itens.add(item);
        imprimirItens();
    }

    public void removerItem(String item){
        itens.remove(item);
        imprimirItens();
    }

    public List<String> getItens() {
        return itens;
    }

    private void imprimirItens(){
        System.out.println("Itens cadastrados: " + itens);
    }

}
