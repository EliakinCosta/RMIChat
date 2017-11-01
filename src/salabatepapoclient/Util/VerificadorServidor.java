package salabatepapoclient.Util;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import salabatepapoclient.interfaces.IServidor;
import salabatepapoclient.interfaces.IVerificador;

public class VerificadorServidor implements IVerificador {

    @Override
    public synchronized boolean verificar() throws RemoteException, NotBoundException {
        boolean isOk = false;
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        isOk = null != registry.lookup(IServidor.REGISTRY_BINDING_NAME);
        System.out.println("Servidor " + (isOk ? "" : "não") + "  ok!");
        return isOk;
    }

}
