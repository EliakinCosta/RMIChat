package salabatepaposerver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements IServidor, Runnable {

    private final ArrayList<ICliente> clientesConectados;

    public Servidor() throws RemoteException {
        clientesConectados = new ArrayList<>();
    }

    @Override
    public synchronized boolean login(ICliente cliente) throws RemoteException {
        String mensagem = cliente.getApelido() + " entrou na sala.";
        cliente.informar("Você entrou na sala.");
        publicarMensagem(mensagem);
        System.out.println(mensagem);
        clientesConectados.add(cliente);
        return true;
    }

    @Override
    public synchronized void publicarMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
        try {
            for (ICliente cliente : clientesConectados) {
                cliente.informar(mensagem);
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
            System.out.println("[Sistema] Seridor do Bate Papo D'uol está online no endereço: " + hostAddress + ".");
        } catch (RemoteException | MalformedURLException | UnknownHostException ex) {
            System.out.println("[Sistema] Servidor fora do ar:\r\n" + ex);
        }
    }

}

class StartServidor {

    public static void main(String[] args) throws RemoteException {
        new Servidor().run();
    }
}
