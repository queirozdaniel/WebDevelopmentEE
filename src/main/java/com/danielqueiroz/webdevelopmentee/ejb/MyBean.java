package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Livro;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MyBean {

    @PersistenceContext
    private EntityManager em;

    public void  mA(){
        Livro l1 = em.find(Livro.class, 1);
        l1.setNumPaginas(200);

        Livro l2 = em.find(Livro.class, 2);
        l2.setNumPaginas(180);
    }

}
