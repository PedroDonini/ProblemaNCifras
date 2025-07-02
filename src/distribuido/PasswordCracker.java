package src.distribuido;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Define o contrato da interface remota para o serviço RMI
public interface PasswordCracker extends Remote {
    String breakPassword(String password) throws RemoteException;
}

