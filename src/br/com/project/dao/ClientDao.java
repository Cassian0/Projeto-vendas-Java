package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//METODO CONSTRUTOR
public class ClientDao {

    private final Connection connection;

    //  CONSTRUTOR
    public ClientDao() {
        this.connection = new ConnectionFactory().getConnection();

    }

    //METODO CADASTRAR CLIENTE
    public void registerClient(Client client) {

        try {

            //COMANDO SQL
            String query = "insert into clients(name,identityDocument,individualRegistration,"
                    + "email,phone,cellPhone,zipCode,address,number,complement,neighborhood,"
                    + "city,state)" 
                   +" values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //CONECTAR E ORGANIZAR SQL
            PreparedStatement prepared = connection.prepareStatement(query);

            prepared.setString(1, client.getName());
            prepared.setString(2, client.getIdentityDocument());
            prepared.setString(3, client.getIndividualRegistration());
            prepared.setString(4, client.getEmail());
            prepared.setString(5, client.getPhone());
            prepared.setString(6, client.getCellPhone());
            prepared.setString(7, client.getZipCode());
            prepared.setString(8, client.getAddress());
            prepared.setInt(9, client.getNumber());
            prepared.setString(10, client.getComplement());
            prepared.setString(11, client.getNeighborhood());
            prepared.setString(12, client.getCity());
            prepared.setString(13, client.getState());

            //EXECUTA O COMANDO SQL
            prepared.execute();
            prepared.close();

            System.out.println("Cadastrado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

    }

}
