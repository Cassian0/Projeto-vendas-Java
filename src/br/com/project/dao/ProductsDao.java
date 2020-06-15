package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Products;
import br.com.project.model.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void registerProducts(Products products) {

        try {
            String query = "INSERT INTO products (description, price, stockQuantity, idProviders) "
                    + "VALUES (?,?,?,?)";
            prepared = connection.prepareStatement(query);
            prepared.setString(1, products.getDescription());
            prepared.setDouble(2, products.getPrice());
            prepared.setInt(3, products.getStockQuantity());
            prepared.setInt(4, products.getProvider().getId());

            prepared.execute();
            prepared.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrato com Sucesso!");

        } catch (SQLException err) {
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
                provider.setName(result.getString("providers.name"));

                products.setProvider(provider);

                dataProducts.add(products);
            }
            return dataProducts;

        } catch (SQLException err) {
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
        } catch (SQLException err) {
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

//    METODO BUSCAR PRODUTO POR NOME DO FORNECEDOR
    public List<Products> searchProductByProviderName(String name) {
        List<Products> dataProducts = new ArrayList<>();

        try {
            String query = "SELECT * FROM products INNER JOIN providers "
                    + "ON products.idProviders = providers.id WHERE name LIKE ?";

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
                provider.setName(result.getString("providers.name"));

                products.setProvider(provider);
                dataProducts.add(products);
            }
            return dataProducts;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

//    CONSULTAR PRODUTO POR NOME
    public Products searchProductsByName(String name) {
        try {
            String query = "SELECT * FROM products INNER JOIN providers"
                    + "ON products.idProviders = providers.id WHERE description ?";
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");
            result = prepared.executeQuery();
            result.next();
            Products products = new Products();
            products.setId(result.getInt("products.id"));
            products.setDescription(result.getString("description"));
            products.setPrice(result.getDouble("price"));
            products.setStockQuantity(result.getInt("stockQuantity"));
            Provider provider = new Provider();
            provider.setName(result.getString("providers.name"));

            products.setProvider(provider);

            return products;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            System.out.println("Erro " + err);
            return null;
        }
    }

//    CONSULTA DE PRODUTO POR ID
    public Products searchProductsByID(int id) {
        try {
            String query = "SELECT * FROM products WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            Products products = new Products();
            products.setId(result.getInt("id"));
            products.setDescription(result.getString("description"));
            products.setPrice(result.getDouble("price"));
            products.setStockQuantity(result.getInt("stockQuantity"));

            return products;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Produto não Encontrado! ");
            System.out.println("Erro " + err);
            return null;
        }
    }

//    METODO DE BAIXA NO ESTOQUE
    public void writeOffStock(int id, int newStockQuantity) {
        try {
            String query = "UPDATE products SET stockQuantity = ? WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            prepared.setInt(2, newStockQuantity);
            prepared.execute();
            prepared.close();

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

//    METODO QUE RETORNA O ESTOQUE
    public int returnCurrentyIventory(int id) {
        try {
            int stockQuantity;
            String query = "SELECT stockQuantity FROM products WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            result.next();
            stockQuantity = (result.getInt("stockQuantity"));

            return stockQuantity;

        } catch (SQLException err) {
            throw new RuntimeException(err);
        }

    }

}
