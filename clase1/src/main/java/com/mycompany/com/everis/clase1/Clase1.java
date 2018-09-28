package com.mycompany.com.everis.clase1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Profe Carlos Rios carlos.rios@educacionit.com   
 * materiales: alumni.educacionit.com
 * user: mail everis    pass: dni
 * 
 */
public class Clase1 {

    public static void main(String[] args) throws Exception{
    
        class Hilo extends Thread{

            private String nombre;

            public Hilo(String nombre) {
                this.nombre = nombre;
            }

            @Override  // Tiene la capacidad de ejecutar en un thread distinto.
            public void run(){ 
                for(int a = 1; a<=10 ; a++){
                    System.out.println(nombre + " " + a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Clase1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        System.out.println("Cant. de nucleos: " + Runtime.getRuntime().availableProcessors());
        
        Hilo hilo1 = new Hilo("hilo1");
        Hilo hilo2 = new Hilo("hilo2");
        Hilo hilo3 = new Hilo("hilo3");
        Hilo hilo4 = new Hilo("hilo4");
        
        System.out.println("Hilo1 - Estado: " + hilo1.getState());

        // El método run no ejecuta en un hilo nuevo
        // hilo1.run();
        // hilo2.run();
        // hilo3.run();
        // hilo4.run();
        
        // El método start ejecuta el método run en un hilo nuevo
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        System.out.println("Hilo1 - Estado: " + hilo1.getState());
        
        Thread.sleep(11000);
        
        System.out.println("Hilo1 - Estado: " + hilo1.getState());
        System.out.println("-- Fin del programa --");
        
        /*
        Ciclo de vida de un Thread
        
        Nuevo(NEW)      Vivo                 Muerto (TERMINATED)
        .start()        RUNNING              Causa natural
                        TIMED_WAITING        Asesinato --> .stop()
                        BLOCKED
        
        */
    }
}
