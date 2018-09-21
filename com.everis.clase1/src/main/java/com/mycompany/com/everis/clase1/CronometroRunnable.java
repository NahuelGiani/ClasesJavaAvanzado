/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.com.everis.clase1;

import javax.swing.JTextField;

/**
 *
 * @author educacionit
 */
public class CronometroRunnable implements Runnable{

    private JTextField txt;
    private boolean correr = false;
    private int cont = 0;
    
    public CronometroRunnable(JTextField txt) {
        this.txt = txt;
    }
    
    public void start(){ correr = true; }
    public void pause(){ correr = false; }
    public void stop(){ 
        correr = false; 
        cont = 0;
        txt.setText("0");
    }

    @Override
    public void run() {
        while(true){
            if(correr){
                cont++;
                txt.setText(cont + "");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
}
