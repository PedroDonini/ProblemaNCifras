package src.paralelo ;
import java.util.*;

public class BruteForceParallel {
    
    // Classe Worker que extende Thread e realiza a quebra da senha
    static class Worker extends Thread {
        private final String password;

        public Worker(String password) {
            this.password = password;
        }

        @Override
        public void run() {
            int max = (int) Math.pow(10, password.length());

            for (int i = 0; i < max; i++) {
                String guess = String.format("%0" + password.length() + "d", i);
                if (guess.equals(password)) {
                    System.out.println("Senha quebrada: " + guess);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> passwords = Arrays.asList("1234", "9999", "0000", "5678", "2468", "1357");

        long start = System.currentTimeMillis(); // Início do tempo

        List<Thread> threads = new ArrayList<>();

        // Cria e inicia uma thread para cada senha
        for (String pwd : passwords) {
            Thread t = new Worker(pwd);
            t.start();         // Inicia a thread
            threads.add(t);    // Guarda para poder aguardar sua finalização depois
        }

        // Aguarda todas as threads terminarem
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis(); // Fim do tempo
        System.out.println("Tempo total (Paralelo): " + (end - start) + "ms");
    }
}
