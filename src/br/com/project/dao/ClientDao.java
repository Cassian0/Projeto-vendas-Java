package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

//METODO CONSTRUTOR
public class ClientDao {

    private final Connection connection;

    public ClientDao() {
        this.connection = new ConnectionFactory().getConnection();

    }

    //MNETODO CADASTRAR CLIENTE
    public void registerClient(Cliente client) {

        try {

            //COMANDO SQL
            String query = "insert into clients(name, identityDocument, individualRegistration,"
                    + "email, phone, cellPhone, zipcode, address, number, complement, neighborhood"
                    + "city, state) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepared = connection.prepareStatement(query);
            prepared.setString(1, client.getName());
            prepared.setString(2, client.getRg());
            prepared.setString(3, client.getCpf());
            prepared.setString(4, client.getEmail());
            prepared.setString(5, client.getTelefone());
            prepared.setString(6, client.getCelular());
            prepared.setString(7, client.getCep());
            prepared.setString(8, client.getEndereco());
            prepared.setInt(9, client.getNumero());
            prepared.setString(10, client.getComplemento());
            prepared.setString(11, client.getBairro());
            prepared.setString(12, client.getCidade());
            prepared.setString(13, client.getEstado());

            //EXECUTA O COMANDO SQL
            prepared.execute();
            prepared.close();

            System.out.println("Cdastrado com sucesso");

        } catch (Exception e) {
            System.out.println(" erro " + e);
        }

    }

}
