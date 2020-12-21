package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Livro;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private MyBean2 myBean2;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
   //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    //@TransactionAttribute(TransactionAttributeType.NEVER)
    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void  mA(){
        Livro l1 = em.find(Livro.class, 1);
        l1.setNumPaginas(200);

        //Livro l2 = em.find(Livro.class, 2);
        //l2.setNumPaginas(180);
        myBean2.mB();
    }

}
