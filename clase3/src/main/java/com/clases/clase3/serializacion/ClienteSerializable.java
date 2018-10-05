package com.clases.clase3.serializacion;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteSerializable {
    
    public static void main(String[] args) throws Exception{
        Persona p1 = new Persona("Nahuel","Giani",23,7);
        
        try(Socket s = new Socket("localhost", 9000);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream())){
            System.out.println("Conectado al servidor");
            out.writeObject(p1);
            System.out.println(in.readUTF());
        }catch(java.lang.Exception e){
            e.printStackTrace();
        }    
    }
    
}
