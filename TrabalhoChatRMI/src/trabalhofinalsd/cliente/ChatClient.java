/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalsd.cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhofinalsd.servidor.ChatServerIF;

/**
 *
 * @author eliakincosta
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable{

    private String name;
    private ChatServerIF chatServer;
    
    public ChatClient(String name, ChatServerIF chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        this.chatServer.registrarChatClient(this);
    }

    @Override
    public void enviarMensagem(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        
        while(true){
            message = scanner.nextLine();
            try {
                chatServer.difundirMensagem(name + ": " + message);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
