package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Livro;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class DBSetupBean {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void initDB(){
        Livro l1 = new Livro();
        l1.setId(1);
        l1.setTitulo("Java Inicial");
        l1.setNumPaginas(300);
        em.persist(l1);

        Livro l2 = new Livro();
        l2.setId(2);
        l2.setTitulo("Java Avançado");
        l2.setNumPaginas(390);
        em.persist(l2);


    }

}
