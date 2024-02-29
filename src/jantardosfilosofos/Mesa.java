/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jantardosfilosofos;

import java.util.ArrayList;

/**
 *
 * @author Daiane
 */
public class Mesa {
    Garfo garfos[]={new Garfo(), new Garfo(), new Garfo(), new Garfo(), new Garfo()};
    
    public synchronized Garfo pegarGarfo(int posicao){
        Garfo garfo = garfos[posicao];
        garfos[posicao] = null;
        return garfo;
    }
    
    public synchronized void devolverGarfo(int posicao, Garfo garfo){
        garfos[posicao] = garfo;
    }
}
