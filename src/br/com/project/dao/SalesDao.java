package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Client;
import br.com.project.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    //METODO FILTRAR VENDAS POR DATA
    public List<Sales> listSaleForDate(LocalDate startDate, LocalDate endDate) {
        //LISTA 
        List<Sales> dataSale = new ArrayList<>();

        try {
            // CRIAR SQL, ORGANIZAR E EXECUTAR
            String query = "SELECT s.id, date_format(s.saleDate, '%d/%m/%Y') as formatSaleDate, s.totalSale, "
                    + "s.observation, c.name FROM sales as s INNER JOIN clients as c "
                    + "ON s.idClient = c.id WHERE s.saleDate BETWEEN ? AND ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, startDate.toString());
            prepared.setString(2, endDate.toString());

            result = prepared.executeQuery();
            while (result.next()) {
                Sales sales = new Sales();
                sales.setId(result.getInt("s.id"));
                sales.setDateSale(result.getString("formatSaleDate"));
                sales.setTotalSale(result.getDouble("s.totalSale"));
                sales.setNote(result.getString("s.observation"));
                Client client = new Client();
                client.setName(result.getString("c.name"));

                // ADICIONANDO O OBJETO CLIENTE DENTRO DO OBJETO VENDAS
                sales.setClient(client);
                dataSale.add(sales);
            }
            return dataSale;
        } catch (SQLException err) {
            System.out.println("Erro" + err);
            return null;
        }
    }

    public double returnTotalSaleForDate(LocalDate saleDate) {

        try {

            double totalSale = 0;

            String query = "SELECT SUM(totalSale) as total FROM sales WHERE saleDate = ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, saleDate.toString());

            result = prepared.executeQuery();
            result.next();

            totalSale = result.getDouble("total");

            return totalSale;

        } catch (SQLException err) {
            throw new RuntimeException(err);
        }
    }

}
