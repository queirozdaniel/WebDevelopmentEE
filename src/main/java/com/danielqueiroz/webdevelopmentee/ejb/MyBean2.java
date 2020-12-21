package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Livro;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean2 {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private EJBContext ejbContext;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void  mB(){
        Livro l2 = em.find(Livro.class, 2);
        l2.setNumPaginas(180);

        ejbContext.setRollbackOnly();
    }

}
