package src.distribuido;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// Inicia o servidor RMI e registra o serviço
public class PasswordCrackerServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Cria o registry RMI na porta padrão
            PasswordCrackerImpl cracker = new PasswordCrackerImpl();
            Naming.rebind("Cracker", cracker);   // Registra o serviço com o nome "Cracker"
            System.out.println("Servidor RMI pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

