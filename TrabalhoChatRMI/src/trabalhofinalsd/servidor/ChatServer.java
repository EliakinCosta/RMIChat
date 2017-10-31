/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalsd.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import trabalhofinalsd.cliente.ChatClientIF;
	
/**
 *
 * @author eliakincosta
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerIF{

    private ArrayList<ChatClientIF> chatClients;
    
    public ChatServer() throws RemoteException {
        chatClients = new ArrayList<ChatClientIF>();
    }
    
    @Override
    public synchronized void registrarChatClient(ChatClientIF chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
    }

    @Override
    public synchronized void difundirMensagem(String message) throws RemoteException {
        for (ChatClientIF chatClient : chatClients){
            chatClient.enviarMensagem(message);
        }
    }
    
}
