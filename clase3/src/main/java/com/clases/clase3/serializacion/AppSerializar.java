package com.clases.clase3.serializacion;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AppSerializar {
   
    public static void main(String[] args) throws Exception{
        
        Persona p1 = new Persona("Mario","Blanco",22,8);
        Persona p2 = new Persona("Laura","Salas",22,12);
        Persona p3 = new Persona("Cristian","Molina",22,45);

        String file = "personas.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);
        oos.close();
    }
}
