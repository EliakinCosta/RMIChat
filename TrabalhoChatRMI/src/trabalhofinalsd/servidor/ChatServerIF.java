/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalsd.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import trabalhofinalsd.cliente.ChatClientIF;

/**
 *
 * @author eliakincosta
 */
public interface ChatServerIF extends Remote{
    void registrarChatClient(ChatClientIF chatClient) throws RemoteException;
    void difundirMensagem(String message) throws RemoteException;
}
