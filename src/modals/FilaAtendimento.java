package modals;
import java.util.HashMap;
import java.util.Map;


public class FilaAtendimento {
    private Fila filaNormal;
    private Fila filaPrioritaria;
    private Map<Integer, String> pacientes; // id -> nome
    private int contadorPrioridade;
    private int idAtual;

    public FilaAtendimento(int capacidade) {
        filaNormal = new Fila(capacidade);
        filaPrioritaria = new Fila(capacidade);
        pacientes = new HashMap<>();
        contadorPrioridade = 0;
        idAtual = 1;
    }

    public void adicionarPaciente(String nome, int prioridade) {
        pacientes.put(idAtual, nome);
        if (prioridade == 1) {
            filaPrioritaria.enfileirar(idAtual);
        } else {
            filaNormal.enfileirar(idAtual);
        }
        idAtual++;
    }

    public String chamarProximoPaciente() {
        if (!filaPrioritaria.vazia() && contadorPrioridade < 2) {
            contadorPrioridade++;
            int id = Integer.parseInt(filaPrioritaria.desenfileirar());
            return "Atendendo (PRIORITÁRIO): " + pacientes.get(id);
        } else if (!filaNormal.vazia()) {
            contadorPrioridade = 0;
            int id = Integer.parseInt(filaNormal.desenfileirar());
            return "Atendendo (NORMAL): " + pacientes.get(id);
        } else if (!filaPrioritaria.vazia()) {
            int id = Integer.parseInt(filaPrioritaria.desenfileirar());
            return "Atendendo (PRIORITÁRIO): " + pacientes.get(id);
        } else {
            return "Nenhum paciente na fila.";
        }
    }
}
