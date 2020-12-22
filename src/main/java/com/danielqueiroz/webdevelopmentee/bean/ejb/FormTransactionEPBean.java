package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.ItensBean;
import com.danielqueiroz.webdevelopmentee.ejb.ItensBean2;
import com.danielqueiroz.webdevelopmentee.model.Item;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("formTransaction")
@SessionScoped
public class FormTransactionEPBean implements Serializable {

    @EJB
    private ItensBean2 itensBean;

    @Inject
    private ExternalContext externalContext;

    private List<Item> itens = new ArrayList<>();

    private Item item = new Item();

    public String adicionar(){
        itens.add(item);
        itensBean.adicionarItem(item);
        item = new Item();
        return "form7?face-redirect=true";
    }

    public String remover(){
        itens.remove(item);
        itensBean.removerItem(item.getId());
        item = new Item();
        return "form7?face-redirect=true";
    }

    public String finalizar(){
        itensBean.finalizar();
        externalContext.invalidateSession(); // invalida a sessão para criar nova com EJB novo
        return "form7?face-redirect=true";
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
