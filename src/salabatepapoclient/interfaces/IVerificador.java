package salabatepapoclient.interfaces;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVerificador extends Remote {

    public boolean verificar() throws RemoteException, NotBoundException;
}
