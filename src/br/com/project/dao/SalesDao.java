package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Client;
import br.com.project.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SalesDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    public SalesDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerSales(Sales sales) {
        try {
            String query = "INSERT INTO sales (idClient, saleDate, totalSale, observation) "
                    + "VALUES (?,?,?,?)";
            prepared = connection.prepareStatement(query);

            prepared.setInt(1, sales.getClient().getId());
            prepared.setString(2, sales.getDateSale());
            prepared.setDouble(3, sales.getTotalSale());
            prepared.setString(4, sales.getNote());
            prepared.execute();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda");
            System.out.println("Erro: " + err);
            System.out.println(sales.getDateSale());
        }
    }

    public int returnLastSale() {
        try {
            int idSale = 0;

            String query = "SELECT MAX(id) id FROM sales";
            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            result.next();
            Sales sales = new Sales();
            sales.setId(result.getInt("id"));

            idSale = sales.getId();
            return idSale;

        } catch (SQLException err) {
            throw new RuntimeException(err);
        }
    }

    public List<Sales> listSales() {

        List<Sales> dataSale = new ArrayList<>();

        try {
            String query = "SELECT * FROM sales";

            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();
            while (result.next()) {
                Sales sales = new Sales();
                sales.setId(result.getInt("id"));
                sales.setDateSale(result.getString("saleDate"));
                sales.setTotalSale(result.getDouble("totalSale"));
                sales.setNote(result.getString("observation"));
                Client client = new Client();
                client.setId(result.getInt("idClient"));
                sales.setClient(client);
                dataSale.add(sales);
            }
            return dataSale;
        } catch (SQLException err) {
            System.out.println("Erro" + err);
            return null;
        }

    }

}
