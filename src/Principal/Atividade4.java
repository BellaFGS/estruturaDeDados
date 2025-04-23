package Principal;
import modals.FilaAtendimento;

import javax.swing.*;

/**
 *
 * @author Isabella Ferreira
 */
public class Atividade4 {
    public static void main(String[] args) {
        FilaAtendimento atendimento = new FilaAtendimento(5);

        atendimento.adicionarPaciente("João", 1);
        atendimento.adicionarPaciente("Maria", 0);
        atendimento.adicionarPaciente("Ana", 1);
        atendimento.adicionarPaciente("Carlos", 0);
        atendimento.adicionarPaciente("Beatriz", 1);

        for (int i = 0; i < 5; i++) {
            String resultado = atendimento.chamarProximoPaciente();
            JOptionPane.showMessageDialog(null,
        ">>> Chamada de atendimento <<<\n" +
                "---------------------------------------------------\n" +
                resultado);
        }
    }
}
