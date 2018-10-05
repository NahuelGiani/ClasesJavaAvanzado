package com.clases.clase3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.control.TextArea;
import javax.net.ssl.SSLServerSocket;
import javax.swing.JTextArea;

public class ChatServer implements Runnable{
    
    private JTextArea swTxa = null;
    private TextArea  fxTxa = null;  

    public ChatServer(JTextArea swTxa) {
        this.swTxa = swTxa;
    }

    public ChatServer(TextArea fxTxa) {
        this.fxTxa = fxTxa;
    }
    
    private void appendText(String text){
        if(swTxa != null){
            swTxa.append(text);
        }
        if(fxTxa != null){
            fxTxa.appendText(text);
        }
    }
    
    private static String mensaje;
    @Override
    public void run(){
        try(ServerSocket ss = new ServerSocket(8000)){
            while(true){
                mensaje = "";
                synchronized(this){
                    try(Socket so = ss.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()))){
                        String ip = so.getInetAddress().getHostAddress();
                        MapaDirecciones.getMap().forEach((k,v)->{
                            if(ip.equals(v)){
                                mensaje += k +": ";
                            }
                        });
                        mensaje += in.readLine()+"\n";
                        appendText(mensaje);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
