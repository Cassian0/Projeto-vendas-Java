package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//METODO CONSTRUTOR
public class ClientDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    //  CONSTRUTOR
    public ClientDao() {
        this.connection = new ConnectionFactory().getConnection();

    }

    //METODO CADASTRAR CLIENTE
    public void registerClient(Client client) {

        try {

            //COMANDO SQL
            String query = "INSERT INTO clients(name,identityDocument,individualRegistration,"
                    + "email,phone,cellPhone,zipCode,address,number,complement,neighborhood,"
                    + "city,state)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //CONECTAR E ORGANIZAR SQL
            prepared = connection.prepareStatement(query);

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

            //EXECUTA E FECHA O COMANDO SQL
            prepared.execute();
            prepared.close();

            System.out.println("Cadastrado com sucesso");

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }
//  METODO LISTAR CLIENTES 

    public List<Client> listClients() {
        List<Client> dataClient = new ArrayList<>();

        try {
//            COMANDO SQL QUE É EXECUTADO NO BANCO DE DADOS
            String sql = "SELECT * FROM clients";
            prepared = connection.prepareStatement(sql);
//            SEMPRE QUE FOR EXECUTADO UM SELECT NO BANCO DE DADOS INSTANCIAR RESULTSET
            result = prepared.executeQuery();

            while (result.next()) {
                Client client = new Client();

                client.setId(result.getInt("id"));
                client.setName(result.getString("name"));
                client.setIdentityDocument(result.getString("identityDocument"));
                client.setIndividualRegistration(result.getString("individualRegistration"));
                client.setEmail(result.getString("email"));
                client.setPhone(result.getString("phone"));
                client.setCellPhone(result.getString("cellPhone"));
                client.setZipCode(result.getString("zipCode"));
                client.setAddress(result.getString("address"));
                client.setNumber(result.getInt("number"));
                client.setComplement(result.getString("complement"));
                client.setNeighborhood(result.getString("newighborhood"));
                client.setCity(result.getString("city"));
                client.setState(result.getString("state"));
//           ADICIONA O CLIENTE NA LISTA DE CLIENTES
                dataClient.add(client);
            }
            return dataClient;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }
//    METODO ALTERAR CLIENTE

    public void changeClient(Client client) {

        try {
//            COMANDO SQL
            String sql = "UPDATE clients SET name = ?, identityDocument = ?, individualRegistration = ?,"
                    + "email = ?, phone = ?, cellPhone = ?, zipCode = ?, address = ?, number = ?,"
                    + "complement = ?, neighborhood = ?, city = ?, state = ? WHERE id = ?";

//            CONECTAR COM O BANCO DE DADOS E ORGANIZAR O COMANDO SQL
            prepared = connection.prepareStatement(sql);
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

            prepared.setInt(14, client.getId());

//          EXECUTA E FECHA O COMANDO SQL
            prepared.execute();
            prepared.close();

            System.out.println("Cliente alterado com sucesso!");

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

//    METODO EXCLUIR CLIENTE
    public void deleteClient(Client client) {

        try {
//            COMANDO SQL
            String sql = "DELETE FROM clients WHERE id = ?";

//            CONECTAR COM O BANCO DE DADOS E ORGANIZAR O COMANDO SQL
            prepared = connection.prepareStatement(sql);
            prepared.setInt(1, client.getId());

//            EXECUTA E FECHA O COMANDO SQL
            prepared.execute();
            prepared.close();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

//    BUSCAR CLIENTE POR NOME
    public List<Client> searchClientByName(String name) {
//        CRIAR LISTA DE CLIENTES
        List<Client> dataClient = new ArrayList<>();

        try {
//        COMANDO SQL
            String sql = "SELECT * FROM clients WHERE name LIKE ?";
            prepared = connection.prepareStatement(sql);
            prepared.setString(1, "%" + name + "%");

            result = prepared.executeQuery();

            while (result.next()) {
                Client client = new Client();

                client.setId(result.getInt("id"));
                client.setName(result.getString("name"));
                client.setIdentityDocument(result.getString("identityDocument"));
                client.setIndividualRegistration(result.getString("individualRegistration"));
                client.setEmail(result.getString("email"));
                client.setPhone(result.getString("phone"));
                client.setCellPhone(result.getString("cellPhone"));
                client.setZipCode(result.getString("zipCode"));
                client.setAddress(result.getString("address"));
                client.setNumber(result.getInt("number"));
                client.setComplement(result.getString("complement"));
                client.setNeighborhood(result.getString("neighborhood"));
                client.setCity(result.getString("city"));
                client.setState(result.getString("state"));

//              ADICIONA O CLIENTE A LISTA DE CLIENTES
                dataClient.add(client);
            }
            return dataClient;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }
}
