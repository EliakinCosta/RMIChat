package salabatepapoclient.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidor extends Remote {

    public final String REGISTRY_BINDING_NAME = "batePapoDuol";

    public boolean registrar(ICliente cliente) throws RemoteException;

    public boolean desregistrar(ICliente cliente) throws RemoteException;

    public void difundirMensagem(String s) throws RemoteException;

    public ArrayList<ICliente> getClientesConectados() throws RemoteException;

}
