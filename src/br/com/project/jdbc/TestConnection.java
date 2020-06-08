package br.com.project.jdbc;

import javax.swing.JOptionPane;

public class TestConnection {

    public void testConnection() {
        try {

            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");
            System.out.println("Erro:" + erro);
        }
    }

}
