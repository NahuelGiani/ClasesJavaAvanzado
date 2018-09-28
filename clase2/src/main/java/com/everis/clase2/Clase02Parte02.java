package com.everis.clase2;

import com.sun.security.ntlm.Client;

public class Clase02Parte02 {
        
    public static void main(String[] args) throws Exception{
        
        class Cuenta{
            private float saldo;
            
            // El modificador synchronized bloquea al objeto para cualquier otro que quiera utilizarlo
            // Si se usa un método synchronized, quiénes quieran consumir cualquier otra cosa del
            // objeto deberán esperar que termine de usarse el método synchronized
            public synchronized void depositar(float monto){
                System.out.println("-- Iniciando deposito --");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) { }
                saldo+=monto;
                System.out.println("-- Depositado: " + monto +". Saldo total: " + saldo);
            }
            
            // TAmbién existe el synchronized parcial
            
            // Solo bloquea lo crítica y permite a los otros hilos comenzar a operar con el objeto antes.
            public void depositarParcial(float monto){
                System.out.println("-- Iniciando deposito --");
                synchronized(this){
                    try { Thread.sleep(2000); } catch (Exception e) { }
                    saldo+=monto;
                }
                System.out.println("-- Depositado: " + monto +". Saldo total: " + saldo);
            }
            
            public void debitar(float monto){
                System.out.println("-- Iniciando débito--");
                try { Thread.sleep(1000); } catch (Exception e) { }
                synchronized(this){
                    if(saldo>=monto){
                        try { Thread.sleep(1000); } catch (Exception e) { }
                        saldo-=monto;
                        System.out.println("-- Debito realizado. Saldo total: " + saldo + " --");
                    } else {
                        System.out.println("-- No hay saldo suficiente --");                        
                    };
                }
                System.out.println("-- Debito finalizado --");
            }

            public void setSaldo(float saldo){
                this.saldo = saldo;
            }
            
            public float getSaldo(){
                return this.saldo;
            }
       
        }

        class Cliente1 implements Runnable{
            private Cuenta cuenta;

            public Cliente1(Cuenta cuenta){
                this.cuenta = cuenta;
            }
            
            public Cuenta getCuenta(){
                return this.cuenta;
            }
            
            @Override
            public void run(){
                cuenta.depositarParcial(10000);
            }
        }
        
        class Cliente2 implements Runnable{
            private Cuenta cuenta;

            public Cliente2(Cuenta cuenta){
                this.cuenta = cuenta;
            }
            
            public Cuenta getCuenta(){
                return this.cuenta;
            }
            
            @Override
            public void run(){
                cuenta.debitar(10000);
            }
        }
        
        Cuenta cuenta = new Cuenta();
        System.out.println("Saldo al principio: " + cuenta.getSaldo());
        Thread c1 = new Thread(new Cliente1(cuenta));
        Thread c2 = new Thread(new Cliente2(cuenta));
        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println("Saldo al final: " + cuenta.getSaldo());
        
        new Thread(new Cliente2(cuenta)).start();
        new Thread(new Cliente2(cuenta)).start();

        Thread.sleep(5000);
                
        System.out.println("Saldo al final: " + cuenta.getSaldo());
    
    }
}
