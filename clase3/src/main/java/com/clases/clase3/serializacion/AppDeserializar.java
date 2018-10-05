package com.clases.clase3.serializacion;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class AppDeserializar {
   
    public static void main(String[] args) throws Exception{
        
        String file = "personas.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Persona persona;
        Integer conta = 0;
        try{
            while(true){
                persona = (Persona) ois.readObject();
                System.out.println(persona);
                conta++;
            }
        }catch(EOFException eof){
            System.out.println("Final del archivo. Personas leídas: " + conta);
        }
        ois.close();
    }
}
