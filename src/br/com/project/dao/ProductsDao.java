package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Products;
import br.com.project.model.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductsDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    public ProductsDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerOProducts(Products products) {

        try {
            String query = "INSERT INTO products (description, price, stockQunatity, idProviders) "
                    + "VALUES (?,?,?,?)";
            prepared = connection.prepareStatement(query);
            prepared.setString(1, products.getDescription());
            prepared.setDouble(2, products.getPrice());
            prepared.setInt(3, products.getStockQuantity());
            prepared.setInt(4, products.getProvider().getId());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrato com Sucesso!");

        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }

    public List<Products> listProducts() {
        List<Products> dataProducts = new ArrayList<>();

        try {
            String query = "SELECT * FROM products INNER JOIN providers ON products.idProviders = providers.id";

            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                Products products = new Products();
                products.setId(result.getInt("products.id"));
                products.setDescription(result.getString("description"));
                products.setPrice(result.getDouble("price"));
                products.setStockQuantity(result.getInt("stockQuantity"));
                Provider provider = new Provider();
                provider.setName(result.getString("name"));

                products.setProvider(provider);

                dataProducts.add(products);
            }
            return dataProducts;

        } catch (Exception err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

    public void changeProducts(Products products) {

        try {
            String query = "UPDATE products SET description = ?, price = ?, stockQuantity = ?, "
                    + "idProviders = ? where id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, products.getDescription());
            prepared.setDouble(2, products.getPrice());
            prepared.setInt(3, products.getStockQuantity());

            prepared.setInt(4, products.getProvider().getId());

            prepared.setInt(5, products.getId());

            prepared.execute();
            prepared.close();;

            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }

    public void deleteProducts(Products products) {

        try {
            String query = "DELETE FROM products WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, products.getId());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
        } catch (Exception err) {
            System.out.println("Erro: " + err);
        }
    }

//    METODO VUSCAR PRODUTO POR NOME DO FORNECEDOR
    public List<Products> searchProductByProviderName(String name) {
        List<Products> dataProducts = new ArrayList<>();

        try {
            String query = "SELECT * FROM products INNER JOIN providers "
                    + "ON products.idProvider = provider.id WHERE name LIKE ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");
            result = prepared.executeQuery();
            while (result.next()) {
                Products products = new Products();
                products.setId(result.getInt("products.id"));
                products.setDescription(result.getString("description"));
                products.setPrice(result.getDouble("price"));
                products.setStockQuantity(result.getInt("stockQuantity"));
                Provider provider = new Provider();
                provider.setName(result.getString("name"));

                products.setProvider(provider);
                dataProducts.add(products);
            }
            return dataProducts;

        } catch (Exception err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

}
