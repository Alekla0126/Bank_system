package com.assignment.bank;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.*;

public class Main extends Policy
{

    private void startServer()
    {
        //This method is responsible to register the remote 
        //objects with the registry so that they can be looked up by the clients.
        try
        {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Bank", new BankImpl());
            System.out.println("Sistema listo");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException
    {
        Main main = new Main();
        // Sets the RMI service to start on local host
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        main.startServer();
    }
}
