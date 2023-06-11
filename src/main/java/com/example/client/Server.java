package com.example.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote implementation class
            MyRemoteInterface remoteObject = new MyRemoteImplementation();

            // Start the RMI registry on the default port (1099)
            Registry registry =  LocateRegistry.createRegistry(1099);

            // Bind the remote object to a name in the RMI registry
            registry.rebind("MyRemoteObject", remoteObject);

            System.out.println("Server started and waiting for client requests...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

