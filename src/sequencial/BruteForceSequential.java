package src.sequencial;
import java.util.*;

public class BruteForceSequential {
    
    // Método que tenta quebrar uma senha usando força bruta
    public static String breakPassword(String target) {
        int max = (int) Math.pow(10, target.length()); // Limite superior das combinações (ex: 10000 para 4 dígitos)
        
        for (int i = 0; i < max; i++) {
            // Formata o número com zeros à esquerda para manter o mesmo número de dígitos
            String guess = String.format("%0" + target.length() + "d", i);
            
            // Compara com a senha alvo
            if (guess.equals(target)) {
                return guess;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Lista de senhas a serem quebradas
        List<String> passwords = Arrays.asList("1234", "9999", "0000", "5678", "2468", "1357");

        long start = System.currentTimeMillis(); // Início da medição de tempo

        // Quebra cada senha uma por vez
        for (String pwd : passwords) {
            String result = breakPassword(pwd);
            System.out.println("Senha quebrada: " + result);
        }

        long end = System.currentTimeMillis(); // Fim da medição
        System.out.println("Tempo total (Sequencial): " + (end - start) + "ms");
    }
}
