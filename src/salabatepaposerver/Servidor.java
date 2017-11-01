package salabatepaposerver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import salabatepapoclient.Util.VerificadorCliente;
import salabatepapoclient.interfaces.ICliente;
import salabatepapoclient.interfaces.IServidor;

public class Servidor extends UnicastRemoteObject implements IServidor, Runnable {

    private final ArrayList<ICliente> clientesConectados;
    private Runnable runnable;

    public Servidor() throws RemoteException {
        clientesConectados = new ArrayList<>();
    }

    @Override
    public synchronized boolean registrar(ICliente cliente) throws RemoteException {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        registry.rebind(cliente.getApelido(), cliente);
        clientesConectados.add(cliente);
        new Thread(new VerificadorCliente(cliente, this)).start();
        return true;
    }

    @Override
    public synchronized boolean desregistrar(ICliente cliente) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            clientesConectados.remove(cliente);
            return true;
        } catch (AccessException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public synchronized void publicarMensagem(String mensagem) throws RemoteException {
        try {
            System.out.println(mensagem);
            for (ICliente cliente : clientesConectados) {
                String replaceMessage = mensagem.replaceFirst(cliente.getApelido() + " disse:", "Você disse:")
                        .replaceFirst(cliente.getApelido() + ", ", "Você, ");
                cliente.informar(replaceMessage);
            }
        } catch (RemoteException ex) {
            System.out.println("Erro ao publicar a mensagem:\r\n" + mensagem + "\r\n" + ex);
        }
    }

    @Override
    public ArrayList<ICliente> getClientesConectados() throws RemoteException {
        return clientesConectados;
    }

    @Override
    public void run() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            IServidor server = new Servidor();
            InetAddress ipAddress = InetAddress.getLocalHost();
            String hostAddress = ipAddress.getHostAddress();

            Naming.rebind("rmi://" + hostAddress + "/batePapoDuol", server);
            System.out.println("[Sistema] Servidor de Bate Papo D'uol está online no endereço: " + hostAddress + ".");

        } catch (RemoteException | MalformedURLException | UnknownHostException ex) {
            System.out.println("[Sistema] Servidor fora do ar:\r\n" + ex);
        }
    }

}

class StartServidor {

    public static void main(String[] args) throws RemoteException {
        Servidor servidor = new Servidor();
        servidor.run();
    }
}
