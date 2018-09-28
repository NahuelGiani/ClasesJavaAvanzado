package com.everis.clase2;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Clase02Parte04ServerMinimo implements Runnable{
    
    public static void main(String[] args) {
        /*
        Protocolo TCP
        
        Server                           Client
        -----------                     -----------
        ServerSocket(port)              Socket()
            .accept()
        -----------                     -----------
        OutputStream   ------------->   InputStream
        InputStream    <-------------   OutputStream
        -----------                     -----------
            .close()                        .close()
        
        
        DataOutputStream   - DataInputStream:   manda/recibe tipos primitivos de Java (double, float, int).
        ObjectOutputStream - ObjectInputStream: manda/recibe objetos de Java(PersonaDTO).
        */
        new Thread(new Clase02Parte04ServerMinimo()).start();
    }
    
    @Override
    public void run(){
       // String mensaje = "Servidor";
        String mensaje = "Servidor";

        // Puertos por debajo del 1024 los usa el SO
        try(ServerSocket ss = new ServerSocket(8001)){ //try with resources --- Se puede usar con elementos que utilicen AutoClosable. Está desde JDK7
            while(true){
                System.out.println("-- Esperando conexión --");
                try(Socket so = ss.accept(); // con .accept() se detiene el hilo de ejecución hasta que un client ingrese
                    OutputStream out = so.getOutputStream();
                ){  
                    System.out.println("-- Cliente conectado. IP: " + so.getInetAddress() + " --");
                    System.out.println("-- Enviando mensaje al cliente --");
                    out.write(mensaje.getBytes());
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
            //ss.close(); Si se usa un Autoclosable en el try, no necesito cerrarlo.
        } catch(Exception e){
                System.out.println(e);
        }
    }

}
