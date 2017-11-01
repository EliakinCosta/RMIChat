package salabatepapoclient.Util;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import salabatepapoclient.interfaces.ICliente;
import salabatepapoclient.interfaces.IServidor;
import salabatepapoclient.interfaces.IVerificador;

public class VerificadorCliente implements IVerificador, Runnable {

    private final ICliente cliente;
    private String nome;
    private final IServidor servidor;

    public VerificadorCliente(ICliente cliente, IServidor servidor) throws RemoteException {
        this.cliente = cliente;
        this.servidor = servidor;
        this.nome = cliente.getApelido();
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

    @Override
    public void run() {
        try {
            while (true) {
                this.verificar();
                Thread.sleep(5000);
            }
        } catch (RemoteException | NotBoundException | InterruptedException ex) {            
            try {
                System.out.println("Cliente " + this.nome + " parou de funcionar");
                this.servidor.desregistrar(this.cliente);
                this.servidor.publicarMensagem(this.nome + " se desconectou");
                if (!Thread.currentThread().isInterrupted()) {
                    Thread.currentThread().interrupt();            
                }
            } catch (RemoteException ex1) {
                Logger.getLogger(VerificadorCliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
