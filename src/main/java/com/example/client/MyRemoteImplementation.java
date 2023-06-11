package com.example.client;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyRemoteImplementation extends UnicastRemoteObject implements MyRemoteInterface {
    public MyRemoteImplementation() throws RemoteException {
       super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "abdelhaq";
    }

    @Override
    public String addStudent(String mdp,String cin,String lastName,String firstName) throws RemoteException{
        String url = "jdbc:mysql://localhost:3306/abdo";
        String username = "root";
        String password = "M0607208947";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO Student (firstName, lastName, cin, mdp) VALUES (?, ?, ?, ?)";

            // Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the parameter values for each record
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, cin);
            statement.setString(4, mdp);
            statement.executeUpdate();


            return "Data inserted successfully.";
        } catch (SQLException e) {
           return "error";
        }
    }
    @Override
    public List<List<String>> getAllStudent() throws RemoteException {
        List<List<String>> studentList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/abdo";
        String username = "root";
        String password = "M0607208947";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Student";

            // Create a Statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate over the result set and fetch student data
            while (resultSet.next()) {
                List<String> studentInfo = new ArrayList<>();
                studentInfo.add(resultSet.getString("studentId"));
                studentInfo.add(resultSet.getString("firstName"));
                studentInfo.add(resultSet.getString("lastName"));
                studentInfo.add(resultSet.getString("cin"));
                studentInfo.add(resultSet.getString("mdp"));

                studentList.add(studentInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

}
