/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modals;

/**
 *
 * @author 0031432512005
 */
public class Pilha {
    private int topo;
    private int tamanho;
    private Object pilhaElem[];
    
    public Pilha(int tam){
        topo = -1;
        tamanho = tam;
        pilhaElem = new Object[tam];
    }
    
    public boolean vazia(){
        if (topo == -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean cheia(){
        if (topo ==  tamanho -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void empilhar(Object elem){
        if(cheia() == true){
            System.out.println("A pilha está cheia!");
        }
        else{
            topo++;
            pilhaElem[topo]=elem;
        }
    }
    
    public Object desempilhar(){
        Object valorDesempilhado;
        if(vazia() == true){
            valorDesempilhado = "Pilha Vazia!";
        }
        else{
            valorDesempilhado = pilhaElem[topo];
            topo--;
        }
        return valorDesempilhado;
    }

}
