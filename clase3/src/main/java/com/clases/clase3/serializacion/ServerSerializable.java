package com.clases.clase3.serializacion;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSerializable implements Runnable{
    
   
    @Override
    public void run(){
        try(ServerSocket ss = new ServerSocket(9000)){
            while(true){
                System.out.println("Esperando conexión del cliente");
                try(Socket s = ss.accept();
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())){
                    try{
                        Persona p = (Persona) in.readObject();
                        out.writeUTF("Objecto recibido");
                    }catch(ClassCastException exc){
                        out.writeUTF("El objecto no es del tipo Persona");
                    }
                } catch (Exception e) {
                
                }
            }
        }catch(java.lang.Exception e){
            e.printStackTrace();
        }
    }
    
}
