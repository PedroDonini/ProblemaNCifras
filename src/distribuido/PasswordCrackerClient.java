package src.distribuido;

import java.rmi.Naming;
import java.util.*;

public class PasswordCrackerClient {
    public static void main(String[] args) {
        try {
            // Conecta ao serviço remoto "Cracker"
            PasswordCracker cracker = (PasswordCracker) Naming.lookup("rmi://localhost/Cracker");
            List<String> passwords = Arrays.asList("1234", "9999", "0000", "5678", "2468", "1357");

            long start = System.currentTimeMillis(); // Início da medição

            for (String pwd : passwords) {
                String result = cracker.breakPassword(pwd); // Chamada remota
                System.out.println("Senha quebrada: " + result);
            }

            long end = System.currentTimeMillis();
            System.out.println("Tempo total (Distribuído RMI): " + (end - start) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

