package com.mycompany.com.everis.clase1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Profe Carlos Rios carlos.rios@educacionit.com   
 * materiales: alumni.educacionit.com
 * user: mail everis    pass: dni
 * 
 */
public class Clase1Parte2 {

    public static void main(String[] args) throws Exception{
    
        class HiloR implements Runnable{
            
            private String nombre;

            public HiloR(String nombre) {
                this.nombre = nombre;
            }
            @Override
            public void run() {
                for(int a = 1; a <= 10; a++){
                    System.out.println(nombre + " " + a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Clase1Parte2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }  
        
        HiloR hiloR1 = new HiloR("hiloR1");
        HiloR hiloR2 = new HiloR("hiloR2");
        HiloR hiloR3 = new HiloR("hiloR3");
        HiloR hiloR4 = new HiloR("hiloR4");
        // Como Runnable no tiene start, necesitamos crear un objeto Thread para cada uno
        Thread tHilo1 = new Thread(hiloR1);
        Thread tHilo2 = new Thread(hiloR2);
        Thread tHilo3 = new Thread(hiloR3);
        Thread tHilo4 = new Thread(hiloR4);

        tHilo1.start();
        tHilo2.start();
        tHilo3.start();
        tHilo4.start();
        //Tambièn es común hacer: 
        new Thread(new HiloR("hiloR5")).start(); // Hilo anonimo
    }
}
