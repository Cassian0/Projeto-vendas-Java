package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Products;
import br.com.project.model.SaleItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SaleItemDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    public SaleItemDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerItem(SaleItem saleItem) {

        try {
            String query = "INSERT INTO saleitems (idSale, idProduct, quantity, subTotal)"
                    + "VALUES (?,?,?,?)";
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, saleItem.getSales().getId());
            prepared.setInt(2, saleItem.getProducts().getId());
            prepared.setInt(3, saleItem.getQuantity());
            prepared.setDouble(4, saleItem.getSubTotal());

            prepared.execute();
            prepared.close();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar item da venda!");
            System.out.println("Erro " + err);
        }
    }

    public List<SaleItem> listSaleItem(int saleId) {

        List<SaleItem> dataSaleItem = new ArrayList<>();

        try {
            String query = "SELECT * FROM saleitems INNER JOIN products"
                    + " ON saleitems.idProduct = products.id WHERE saleitems.id = ?";
            prepared = connection.prepareStatement(query);
            prepared.setInt(1, saleId);

            result = prepared.executeQuery();
            while (result.next()) {
                SaleItem saleItem = new SaleItem();
                saleItem.setQuantity(result.getInt("quantity"));
                saleItem.setSubTotal(result.getDouble("subTotal"));
                Products products = new Products();
                products.setDescription(result.getString("description"));
                products.setPrice(result.getDouble("price"));

                saleItem.setProducts(products);
                dataSaleItem.add(saleItem);
            }
            return dataSaleItem;

        } catch (SQLException err) {
            throw new RuntimeException(err);
        }
    }

}
