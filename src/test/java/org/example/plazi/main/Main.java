package org.example.plazi.main;

import org.example.plazi.model.Employee;
import org.example.plazi.repository.EmployeeRepository;
import org.example.plazi.repository.Repository;
import org.example.plazi.util.DatabaseConnection;
import org.example.plazi.view.SwingApp;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SwingApp app = new SwingApp();
        app.setVisible(true);

    }
}