package com.prodcons;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.*;

/**
 *
 * @author Utente
 */
public class Consumatore extends Thread {

    int dato;
    LinkedBlockingQueue coda;

    public Consumatore(LinkedBlockingQueue coda) {
        this.coda = coda;
    }

    @Override
    public void run() {

        for (int i = 0; i < NewMain.tanti; i++) {
            try {
                Object value = coda.take();
                System.out.println(Thread.currentThread().getName() + " Dato letto: " + value);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumatore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
