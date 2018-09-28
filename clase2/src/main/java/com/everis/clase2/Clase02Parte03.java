package com.everis.clase2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Clase02Parte03 {
    public static void main(String[] args) {
        //Diferencias entre Hashtable y HashMap
        System.out.println("*******HASHTABLE********");
        Map<String, String> hashTable = new Hashtable();
        hashTable.put("lu", "Lunes");
        hashTable.put("ma", "Martes");
        hashTable.put("mi", "Miércoles");
        hashTable.put("ju", "Jueves");
        hashTable.put("vi", "Viernes");
        hashTable.forEach((k,v)->System.out.println(k+" "+v));
        System.out.println("************************");
        System.out.println("********HASHMAP*********");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("lu", "Lunes");
        hashMap.put("ma", "Martes");
        hashMap.put("mi", "Miércoles");
        hashMap.put("ju", "Jueves");
        hashMap.put("vi", "Viernes");
        hashMap.forEach((k,v)->System.out.println(k+" "+v));
        System.out.println("************************");
        //Hasta acá parecen iguales, pero:
        // 1) Los métodos del hashtable son todos synchronized. Los de Hashmap no.
        // 2) Hashtable es apta para safeThread (trabajar sobre hilos), Hashmap no es apta.
        // 3) Hashtable tiene menos performance, HashMap mayor.
        // 3) Hashtable no permite nulos, HashTable si.
        //
        //Interfaz Collections: Fabrica colecciones con métodos parcialmente sincronizados.
        //Se pueden crear con colecciones ya existentes o con nuevas:
        //Map<String, String> mapaC = Collections.synchronizedMap(hashMap);
        System.out.println("**HASHMAP SYNCHRONIZED**");
        Map<String, String> mapaC = Collections.synchronizedMap(hashMap);
        mapaC.forEach((k,v)->System.out.println(k + " " + v));
        System.out.println("************************");
    }
}
