package salabatepapoclient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidor extends Remote {

    public boolean login(ICliente cliente) throws RemoteException;

    public void publicarMensagem(String s) throws RemoteException;

    public ArrayList<ICliente> getClientesConectados() throws RemoteException;
}
