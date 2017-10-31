/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalsd.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author eliakincosta
 */
public class ChatServerDriver {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Naming.rebind("RMIChatServer", new ChatServer());
    }
    
    
}
