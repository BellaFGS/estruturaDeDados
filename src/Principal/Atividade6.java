package Principal;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

public class Atividade6 {
    public static void main(String[] args) {
        int[][] notas = new int[3][3];
        int[] medias = new int[3];
        int maiorMedia = Integer.MIN_VALUE;
        int menorMedia = Integer.MAX_VALUE;
        String aprovados = "";

        // Mapeamento de nomes dos alunos (ajustado para 3)
        Map<Integer, String> nomesAlunos = new HashMap<>();
        nomesAlunos.put(0, "Ana");
        nomesAlunos.put(1, "Bruno");
        nomesAlunos.put(2, "Carla");

        // Leitura das notas
        for (int i = 0; i < 3; i++) {
            int soma = 0;
            for (int j = 0; j < 3; j++) {
                notas[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                        "Digite a nota " + (j + 1) + " de " + nomesAlunos.get(i) + ":"
                ));
                soma += notas[i][j];
            }
            medias[i] = soma / 3;

            // Verifica maior e menor média
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
            }

            // Verifica aprovação
            if (medias[i] >= 7) {
                aprovados += nomesAlunos.get(i) + " (Média: " + String.format("%.2f", (double) medias[i]) + ")\n";
            }
        }

        // Exibe resultados
        String resultado = "Médias dos alunos:\n";
        for (int i = 0; i < 3; i++) {
            resultado += nomesAlunos.get(i) + ": " + String.format("%.2f", (double) medias[i]) + "\n";
        }

        resultado += "\nMaior média: " + String.format("%.2f", (double) maiorMedia);
        resultado += "\nMenor média: " + String.format("%.2f", (double) menorMedia);
        resultado += "\n\nAlunos aprovados (média ≥ 7.0):\n" +
                (aprovados.isEmpty() ? "Nenhum aluno aprovado." : aprovados);

        JOptionPane.showMessageDialog(null, resultado);
    }
}
