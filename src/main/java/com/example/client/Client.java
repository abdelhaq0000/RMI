package com.example.client;


import java.rmi.Naming;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            // Look up the remote object by its registered name in the RMI registry
            MyRemoteInterface remoteObject = (MyRemoteInterface) Naming.lookup("rmi://127.0.0.1:1099/MyRemoteObject");
            //remoteObject.addStudent();
            // Invoke the remote method to retrieve data
            String data = remoteObject.addStudent("123","FD30","elmetlini","abdelhaq");
            List<List<String>> students = remoteObject.getAllStudent();
            for (List<String> studentInfo : students) {
                // Loop over each attribute of the student
                for (String attribute : studentInfo) {
                    System.out.print(attribute + " ");
                }
                System.out.println(); // Print a new line after each student
            }

            // Process the data received from the server
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

