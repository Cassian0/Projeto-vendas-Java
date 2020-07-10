package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProviderDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    public ProviderDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerProvider(Provider provider) {
        try {
            String query = "INSERT INTO providers (name, companyIdentificationNumber, email, phone,"
                    + "cellPhone, zipCode, address, number, complement, neighborhood,"
                    + "city, state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, provider.getName());
            prepared.setString(2, provider.getCompanyIdentificationNumber());
            prepared.setString(3, provider.getEmail());
            prepared.setString(4, provider.getPhone());
            prepared.setString(5, provider.getCellPhone());
            prepared.setString(6, provider.getZipCode());
            prepared.setString(7, provider.getAddress());
            prepared.setInt(8, provider.getNumber());
            prepared.setString(9, provider.getComplement());
            prepared.setString(10, provider.getNeighborhood());
            prepared.setString(11, provider.getCity());
            prepared.setString(12, provider.getState());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public List<Provider> listProvider() {
        List<Provider> dataProvider = new ArrayList<>();

        try {
            String query = "SELECT * FROM providers";

            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                Provider provider = new Provider();

                provider.setId(result.getInt("id"));
                provider.setName(result.getString("name"));
                provider.setCompanyIdentificationNumber(result.getString("companyIdentificationNumber"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCellPhone(result.getString("cellPhone"));
                provider.setZipCode(result.getString("zipCode"));
                provider.setAddress(result.getString("address"));
                provider.setNumber(result.getInt("number"));
                provider.setComplement(result.getString("complement"));
                provider.setNeighborhood(result.getString("neighborhood"));
                provider.setCity(result.getString("city"));
                provider.setState(result.getString("state"));

                dataProvider.add(provider);
            }
            return dataProvider;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

    public void changeProvider(Provider provider) {

        try {
            String query = "UPDATE providers SET name = ?, companyIdentificationNumber = ?, email = ?,"
                    + "phone = ?, cellPhone = ?, zipCode = ?, address = ?, number = ?, complement = ?,"
                    + "neighborhood = ?, city = ?, state = ? WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, provider.getName());
            prepared.setString(2, provider.getCompanyIdentificationNumber());
            prepared.setString(3, provider.getEmail());
            prepared.setString(4, provider.getPhone());
            prepared.setString(5, provider.getCellPhone());
            prepared.setString(6, provider.getZipCode());
            prepared.setString(7, provider.getAddress());
            prepared.setInt(8, provider.getNumber());
            prepared.setString(9, provider.getComplement());
            prepared.setString(10, provider.getNeighborhood());
            prepared.setString(11, provider.getCity());
            prepared.setString(12, provider.getState());

            prepared.setInt(13, provider.getId());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Alterado com Sucesso!");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public void deleteProvider(Provider provider) {

        try {
            String query = "DELETE FROM providers WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, provider.getId());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Excluido com Sucesso!");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public List<Provider> searchProviderByName(String name) {
        List<Provider> dataProvider = new ArrayList<>();

        try {
            String query = "SELECT * FROM providers WHERE name LIKE ?";
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");

            result = prepared.executeQuery();

            while (result.next()) {
                Provider provider = new Provider();

                provider.setId(result.getInt("id"));
                provider.setName(result.getString("name"));
                provider.setCompanyIdentificationNumber(result.getString("companyIdentificationNumber"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCellPhone(result.getString("cellPhone"));
                provider.setZipCode(result.getString("zipCode"));
                provider.setAddress(result.getString("address"));
                provider.setNumber(result.getInt("number"));
                provider.setComplement(result.getString("complement"));
                provider.setNeighborhood(result.getString("neighborhood"));
                provider.setCity(result.getString("city"));
                provider.setState(result.getString("state"));

                dataProvider.add(provider);
            }

            return dataProvider;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

}
