import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;

public class CadastroNomes {

    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        int opcao = 0;

        do {
            String menu = """
                MENU:
                1 - Adicionar nome
                2 - Remover nome
                3 - Listar nomes (ordenado)
                4 - Buscar nome
                5 - Sair
                """;
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;
            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog("Digite o nome a ser adicionado:");
                    if (nome != null && !nome.trim().isEmpty()) {
                        nomes.add(nome.trim());
                        JOptionPane.showMessageDialog(null, "Nome adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                    }
                }
                case 2 -> {
                    String nome = JOptionPane.showInputDialog("Digite o nome a ser removido:");
                    if (nome != null) {
                        if (nomes.remove(nome.trim())) {
                            JOptionPane.showMessageDialog(null, "Nome removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome não encontrado.");
                        }
                    }
                }
                case 3 -> {
                    if (nomes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia.");
                    } else {
                        ArrayList<String> nomesOrdenados = new ArrayList<>(nomes);
                        Collections.sort(nomesOrdenados);
                        StringBuilder lista = new StringBuilder("Nomes cadastrados:\n");
                        for (String nome : nomesOrdenados) {
                            lista.append("- ").append(nome).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                }
                case 4 -> {
                    String nome = JOptionPane.showInputDialog("Digite o nome a ser buscado:");
                    if (nome != null) {
                        if (nomes.contains(nome.trim())) {
                            JOptionPane.showMessageDialog(null, "Nome está cadastrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome não encontrado.");
                        }
                    }
                }
                case 5 -> JOptionPane.showMessageDialog(null, "Saindo do programa.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 5);
    }
}
