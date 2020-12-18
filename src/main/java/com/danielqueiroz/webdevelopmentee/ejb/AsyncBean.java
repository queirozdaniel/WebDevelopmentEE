package com.danielqueiroz.webdevelopmentee.ejb;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

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

    @Asynchronous
    public Future<Integer> processarERetornar(){
        int total = 0;
        for (int i = 0; i <= 10; i++) {
            total += 1;
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new AsyncResult<Integer>(total);
    }

}
