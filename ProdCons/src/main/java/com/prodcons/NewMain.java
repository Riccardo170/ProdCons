package com.prodcons;

import java.util.concurrent.*;

/**
 *
 * @author Utente
 */
public class NewMain {

    protected static int dato = 0;
    protected static int tanti = 9;

  
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue coda = new LinkedBlockingQueue(tanti);

        //LinkedBlockingQueue
        //Produttore: put()
        //Consumatore: take()
        Produttore p1 = new Produttore(coda);
        Produttore p2 = new Produttore(coda);
        Produttore p3 = new Produttore(coda);

        Consumatore c1 = new Consumatore(coda);
        Consumatore c2 = new Consumatore(coda);
        Consumatore c3 = new Consumatore(coda);

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();

        p1.join();
        p2.join();
        p3.join();

        c1.stop();
        c2.stop();
        c3.stop();

    }

}
