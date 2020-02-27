package br.com.project.jdbc;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {
        ConnectionFactory conn = new ConnectionFactory();
        Connection connection = conn.getConnection();
        try {
            if (connection != null) {
                System.out.println(connection);
            }

        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }

    }
}
