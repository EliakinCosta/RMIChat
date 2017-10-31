/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalsd.cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author eliakincosta
 */
public interface ChatClientIF extends Remote{
    void enviarMensagem(String message) throws RemoteException;
}
