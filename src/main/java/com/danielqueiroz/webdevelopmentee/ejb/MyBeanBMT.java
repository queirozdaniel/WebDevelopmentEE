package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Livro;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyBeanBMT {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public void mA() throws Exception{
        List<Livro> livros = em.createQuery("select l from Livro l order by l.id", Livro.class).getResultList();
        for (Livro livro: livros) {
            ut.begin();

            livro.setTitulo("?? ??");
            em.merge(livro);

            if (livro.getId() == 3){
                ut.rollback();
                continue;
            }

            ut.commit();
        }

    }

}
