package com.danielqueiroz.webdevelopmentee.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean {

    private String page;

    public String goTo(){
        if ("b".equals(page)){
            return "page_two";
        } else {
            return "index";
        }
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
