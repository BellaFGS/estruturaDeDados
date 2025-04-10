/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.util.Stack;
import javax.swing.JOptionPane;
import modals.Pilha;

/**
 *
 * @author Arthur Gaspare
 * @author Isabella Ferreira
 */
public class Atividade01 {
    public static boolean ehPalindromo(String palavra){
        // criando uma pilha para guardar as palavras/frases
        Pilha p = new Pilha(50);
        
        //empilhando os caracteres da palavra/frase na pilha
        for (int i = 0; i < palavra.length(); i++){
            char espaco = palavra.charAt(i); // ignora os espaços e continua
            if (espaco == ' '){
                continue;
            }
            p.empilhar(palavra.charAt(i));
        }
        
        //compara os caracteres desempilhados com os caracteres da palavra original
        for (int i = 0; i < palavra.length(); i++){
            char espaco = palavra.charAt(i); // ignora os espaços e continua
            if (espaco == ' '){
                continue;
            }
            if (palavra.charAt(i) != (char) p.desempilhar()){
                return false;
            }
        }
        return true; // se todos os caracteres corresponderem então a palavra é um palindromo
    } 
    public static void main(String[] args){

        String palavra = JOptionPane.showInputDialog("Informe a palavra desejada:");
        if (ehPalindromo(palavra)) {
            System.out.println(palavra + " é um palíndromo.");
        } else {
            System.out.println(palavra + " não é um palíndromo.");
        }
    };
    

    
}
