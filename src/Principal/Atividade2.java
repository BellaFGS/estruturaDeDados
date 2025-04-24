package Principal;

import javax.swing.JOptionPane;
import modals.Pilha;

/**
 *
 * @author Isabella Ferreira
 */

public class Atividade2 {
    public static void main(String[] args) {  
        Pilha p = new Pilha(12);
        char topo;
        int cfCount = 0; // contador de fechamentos corretos
        int sfCount = 0; // contador de fechamentos sem aberturas
        int saCount = 0; // contador de aberturas sem fechamentos
        boolean erroCorrespondencia = false;

        String frase = JOptionPane.showInputDialog("Digite uma expressão como: '[({})]'"); 
        
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

//          Ignorando os espaços
            if (c == ' ') {
                continue;
            }

            if (c == '(') { 
                p.empilhar(')'); 
            } else if (c == '{') { 
                p.empilhar('}'); 
            } else if (c == '[') { 
                p.empilhar(']'); 
            } 
            else if (c == ')' || c == ']' || c == '}') {
                if (p.vazia()) {
                    sfCount++; // símbolo de abertura sem fechamento
                } else {
                    topo = (char) p.desempilhar();
                    if (topo != c) {
                        erroCorrespondencia = true;
                        break; // se abriu com um tipo e fechou com outro, sai fora
                    } else {
                        cfCount++;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Caractere desconhecido detectado: " + c);
                return;
            }
        }

        saCount = p.quantidadeEmpilhados();

        if (erroCorrespondencia) {
            saCount = p.quantidadeEmpilhados();
            JOptionPane.showMessageDialog(null,
        "Os símbolos não estão balanceados (abertura e fechamento não coincidem)!\n" +
                "-------------------------------------------------------------------------------------------\n" +
                "Símbolos fechados corretamente: " + cfCount + "\n" +
                "Fechamentos sem abertura: " + sfCount + "\n" +
                "Aberturas sem fechamento: " + saCount + "\n" +
                "Símbolos totais na expressão: " + frase.length());
        }
        else if (!p.vazia()) {
            saCount = p.quantidadeEmpilhados();
            JOptionPane.showMessageDialog(null,
        "Há caracteres de abertura sem fechamento!\n" +
                "---------------------------------------------------------------------------------------------\n" +
                "Símbolos fechados corretamente: " + cfCount + "\n" +
                "Fechamentos sem abertura: " + sfCount + "\n" +
                "Aberturas sem fechamento: " + saCount + "\n" +
                "Símbolos totais na expressão: " + frase.length());
        }
        else if (sfCount > 0) {
            JOptionPane.showMessageDialog(null, 
                "Existem " + sfCount + " fechamento(s) sem abertura correspondente!\n" +
                "-----------------------------------------------------------------------------------------------\n" +
                "Símbolos fechados corretamente: " + cfCount + "\n" +
                "Símbolos totais na expressão: " + frase.length());
        } else {
            JOptionPane.showMessageDialog(null, 
        "Tudo certo!\n" +
                "-----------------------------------------------------------------------------------------------\n" +
                "Total de pares balanceados: " + cfCount);
        }
    }
}
