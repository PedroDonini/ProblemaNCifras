package src.distribuido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementa o método de força bruta como serviço remoto
public class PasswordCrackerImpl extends UnicastRemoteObject implements PasswordCracker {
    
    protected PasswordCrackerImpl() throws RemoteException {
        super();
    }

    // Lógica de quebra da senha (mesma da versão sequencial)
    @Override
    public String breakPassword(String password) throws RemoteException {
        int max = (int) Math.pow(10, password.length());
        for (int i = 0; i < max; i++) {
            String guess = String.format("%0" + password.length() + "d", i);
            if (guess.equals(password)) {
                return guess;
            }
        }
        return null;
    }
}

