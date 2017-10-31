package salabatepaposerver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote {

    public void informar(String name) throws RemoteException;

    public String getApelido() throws RemoteException;
}
