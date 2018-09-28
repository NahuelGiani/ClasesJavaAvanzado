package com.everis.clase2;

public class Clase02 {

    public static void main(String[] args) throws Exception{
            //Sincronización de hilos
        class HiloR implements Runnable{
            private final String nombre;
            private final int time;

            public HiloR(String nombre, int time){
                    this.nombre = nombre;
                    this.time = time;
            }

            @Override
            public void run(){
                    for(int i = 1; i <= 50 ; i++){
                        System.out.println(nombre + " " + i);
                            try{
                                Thread.sleep(time);
                            }catch(Exception e){

                            }
                        //Thread.yield(); // Antes se usaba, ahora es un poco obsoleto
                                          // Al llegar a este punto, el hilo le avisa al procesador
                                          // que debe pasar a otro hilo.
                    }
            }
        }

        HiloR h1 = new HiloR("hilo1", 300);
        HiloR h2 = new HiloR("hilo2", 200);
        HiloR h3 = new HiloR("hilo3", 100);
        HiloR h4 = new HiloR("hilo4", 0);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);

        System.out.println(t1.getPriority());
        // .setPriority
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(5);
        t4.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());


        // Metodo .join()

        t1.start();
       // t1.join(); // Si lo dejo aca el hilo 1 se une al principal y no arranca lo demas hasta terminar
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("-- Fin del programa --");
    }
}
