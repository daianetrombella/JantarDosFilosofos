/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jantardosfilosofos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class JantarDosFilosofos {

    public static void main(String[] args) {
        Mesa m = new Mesa();
        Filosofo[] filosofos={new Filosofo("f1", 0,1, m), new Filosofo("f2",1,2,m), new Filosofo("f3",2,3,m), new Filosofo("f4",3,4,m), new Filosofo("f5", 4, 0,m)};
        
        ArrayList<Thread> arr = new ArrayList<Thread>();
        Thread r1 = new Thread(filosofos[0]);
        Thread r2 = new Thread(filosofos[1]);
        Thread r3 = new Thread(filosofos[2]);
        Thread r4 = new Thread(filosofos[3]);
        Thread r5 = new Thread(filosofos[4]);
        arr.add(r1);
        arr.add(r2);
        arr.add(r3);
        arr.add(r4);
        arr.add(r5);
        arr.forEach(a -> a.start());
        arr.forEach(a -> {
            try {
                a.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
