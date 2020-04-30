package br.com.project.jdbc;

import javax.swing.JOptionPane;

public class TestConnection {

    public static void main(String[] args) {

        try {

            new ConnectionFactory().getConnection();
            System.out.println("Conectado com sucesso");

        } catch (Exception erro) {
            System.out.println("Erro:" + erro);
        }

    }

}
