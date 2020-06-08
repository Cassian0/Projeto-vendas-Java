package br.com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {

        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/salesdb", "root", "");

        } catch (SQLException erro) {
            throw new RuntimeException(erro);

        }

    }
}
