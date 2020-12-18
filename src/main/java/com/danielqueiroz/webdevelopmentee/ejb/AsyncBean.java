package com.danielqueiroz.webdevelopmentee.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBean {

    @Asynchronous
    public void processar(){
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
