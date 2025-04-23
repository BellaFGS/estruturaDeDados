import javax.swing.JOptionPane;

public class Palindromo {
    public static void main(String[] args) {
        int opcao = 0;

        do {
            String menu = """
                MENU:
                1 - Verificar se é palíndromo
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
                    String palavra = JOptionPane.showInputDialog("Digite uma palavra:");
                    if (palavra != null) {
                        boolean resultado = ehPalindromo(palavra);
                        String mensagem = resultado ? "É um palíndromo!" : "Não é um palíndromo.";
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
                case 2 -> JOptionPane.showMessageDialog(null, "Saindo do programa.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 2);
    }

    public static boolean ehPalindromo(String palavra) {
        palavra = palavra.replaceAll("\\s+", "");

        Pilha p = new Pilha(palavra.length());

        for (int i = 0; i < palavra.length(); i++) {
            p.empilhar(palavra.charAt(i));
        }

        StringBuilder invertida = new StringBuilder();
        while (!p.vazia()) {
            invertida.append(p.desempilhar());
        }

        return palavra.equals(invertida.toString());
    }
}