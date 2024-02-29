/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jantardosfilosofos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class Filosofo implements Runnable{
    private String nome;
    private int garfoEsquerdo_index;
    private int garfoDireito_index;
    private Mesa mesa;
    private String estado = "pensando";

    public Filosofo(String nome, int ge, int gd, Mesa mesa) {
        this.nome = nome;
        this.garfoDireito_index = gd;
        this.garfoEsquerdo_index = ge;
        this.mesa = mesa;
    }
    
    public void pensando(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void comendo(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        while(true){
            System.out.println(nome +" "+ estado);
            pensando();
            estado = "faminto";
            System.out.println(this.nome +" "+ estado);
            Garfo garfoEsquerdo = mesa.pegarGarfo(garfoEsquerdo_index);
            if(garfoEsquerdo != null){
                //FILOSOFO PEGOU O GARFO ESQUERDO
                Garfo garfoDireito = mesa.pegarGarfo(garfoDireito_index);
                if(garfoDireito != null){//FILOSOFO PEGOU O GARFO DIREITO
                    estado = "comendo";
                    System.out.println(nome +" "+ estado);
                    comendo();
                    mesa.devolverGarfo(garfoDireito_index, garfoDireito);
                    mesa.devolverGarfo(garfoEsquerdo_index, garfoEsquerdo);
                }else{//FILOSOFO NÃO PEGOU O GARFO DIREITO
                    mesa.devolverGarfo(garfoEsquerdo_index, garfoEsquerdo);
                    System.out.println(nome + " não conseguiu pegar o garfo da direita");
                }
            }
        }
    }
}
