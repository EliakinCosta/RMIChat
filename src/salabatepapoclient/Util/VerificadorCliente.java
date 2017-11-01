package salabatepapoclient.Util;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import salabatepapoclient.interfaces.ICliente;
import salabatepapoclient.interfaces.IVerificador;

public class VerificadorCliente implements IVerificador {

    private final ICliente cliente;

    public VerificadorCliente(ICliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public synchronized boolean verificar() throws RemoteException, NotBoundException {
        boolean isOk = false;
        String apelido = cliente.getApelido();
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        isOk = null != registry.lookup(apelido);
        System.out.println("Cliente: " + apelido + ", " + (isOk ? "" : "não") + " ok.");
        return isOk;
    }

}
