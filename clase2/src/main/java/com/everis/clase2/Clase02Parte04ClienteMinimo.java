package com.everis.clase2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Clase02Parte04ClienteMinimo {
    
    public static void main(String[] args) throws Exception{
        Socket so = new Socket("10.12.1.255", 8000);
        InputStream in = so.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        // Esto: 
        br.lines().forEach(item->System.out.println(item));
        // o esto:
        br.lines().forEach(System.out::println);
        //System.out.println(br.readLine());
    }
    
}
