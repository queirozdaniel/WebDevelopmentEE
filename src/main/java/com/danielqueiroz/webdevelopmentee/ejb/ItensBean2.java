package com.danielqueiroz.webdevelopmentee.ejb;

import com.danielqueiroz.webdevelopmentee.model.Item;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.List;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) // Não usa transação
public class ItensBean2 {

    @PersistenceContext(type = PersistenceContextType.EXTENDED) // O contexto de persistencia vai ser mantido em multiplas chamadas
    private EntityManager em;

    public void adicionarItem(Item item){
        em.persist(item); // Sem uma transação
    }

    public void removerItem(int itemId){
        Item item = em.find(Item.class, itemId);
        em.remove(item); // Sem uma transação
    }

    @Remove
    @TransactionAttribute(TransactionAttributeType.REQUIRED) // Cria uma transação
    public void finalizar(){
        // Tudo que estava no PersisteContext vai ser comitado
        System.out.println("Commit Realizado!");
    }

}
