package com.mycompany.com.everis.clase1;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class ReproductorRunnable implements Runnable{
    
    private boolean playing = false;
    
    @Override
    public void run() {           
        try {
            //if()
            //Thread.sleep(1000);
            new Player(new FileInputStream("src/main/resources/Kalimba.mp3")).play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
