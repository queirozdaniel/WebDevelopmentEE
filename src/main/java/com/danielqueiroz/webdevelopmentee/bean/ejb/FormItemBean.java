package com.danielqueiroz.webdevelopmentee.bean.ejb;

import com.danielqueiroz.webdevelopmentee.ejb.ItensBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named("formItem")
@SessionScoped
public class FormItemBean implements Serializable {

    @Inject
    @RequestParameterMap
    private Map<String, String> params;

    @EJB
    private ItensBean itensBean;

    private String item;

    public List<String> getItens(){
        return itensBean.getItens();
    }

    public void adicionar(AjaxBehaviorEvent event){
        itensBean.adicionarItem(item);
        item = null;
    }

    public void remover(AjaxBehaviorEvent event){
        String itemToRemove = params.get("itemToRemove");
        itensBean.removerItem(itemToRemove);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
