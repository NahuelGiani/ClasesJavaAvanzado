package com.mycompany.com.everis.clase1;

import java.time.LocalDateTime;
import javax.swing.JTextField;

public class HoraRunnable implements Runnable{

    private JTextField txt;

    public HoraRunnable(JTextField txt) {
        this.txt = txt;
    }
    
    @Override
    public void run() {
        while(true){
                LocalDateTime ldt = LocalDateTime.now();
                txt.setText(
                        ((ldt.getHour()<10)   ? "0"+ldt.getHour()   : ""+ldt.getHour())   +":"
                      + ((ldt.getMinute()<10) ? "0"+ldt.getMinute() : ""+ldt.getMinute()) +":"
                      + ((ldt.getSecond()<10) ? "0"+ldt.getSecond() : ""+ldt.getSecond())
                );
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
    
}
