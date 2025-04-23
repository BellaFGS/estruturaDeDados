import javax.swing.JOptionPane;

public class ConverterBinario {

    public static void main(String[] args) {
        int opcao = 0;

        do {
            String menu = """
                MENU:
                1 - Converter número decimal para binário
                2 - Sair
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
                    String entrada = JOptionPane.showInputDialog("Digite um número decimal:");
                    if (entrada != null) {
                        try {
                            int numero = Integer.parseInt(entrada);
                            String binario = converterParaBinario(numero);
                            JOptionPane.showMessageDialog(null, "Binário: " + binario);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Digite um número inteiro válido.");
                        }
                    }
                }
                case 2 -> JOptionPane.showMessageDialog(null, "Saindo do programa.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 2);
    }

    public static String converterParaBinario(int numero) {
        if (numero == 0) return "0";

        Pilha p = new Pilha(32);
        while (numero > 0) {
            int resto = numero % 2;
            p.empilhar(resto);
            numero = numero / 2;
        }

        StringBuilder binario = new StringBuilder();
        while (!p.vazia()) {
            binario.append(p.desempilhar());
        }

        return binario.toString();
    }
}
