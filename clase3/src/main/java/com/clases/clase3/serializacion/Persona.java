package com.clases.clase3.serializacion;
import java.io.Serializable;

public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private int edad;
    private transient int codigo;

    public Persona() { }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido, int edad, int codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre 
               + ", apellido=" + apellido 
               + ", edad=" + edad 
               + ", codigo=" + codigo + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
