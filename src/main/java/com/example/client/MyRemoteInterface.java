package com.example.client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemoteInterface extends Remote {
    // Declare remote methods
    String sayHello() throws RemoteException;
    String addStudent(String mdp,String cin,String lastName,String firstName)throws RemoteException;
    List<List<String>> getAllStudent()throws RemoteException;
}
