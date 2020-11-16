package com.danielqueiroz.webdevelopmentee.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean {

    @Inject
    private Flash flash;

    private String page;
    private String name;

    public String goTo() {
        if ("b".equals(page)) {
            return "page_two";
        } else {
            return "index";
        }
    }

    public String processar(){
        //Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("nomeDoUsuario",name);

        return "result?faces-redirect=true";
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
