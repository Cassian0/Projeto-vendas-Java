package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private final Connection connection;
    private PreparedStatement prepared;
    private ResultSet result;

    public EmployeeDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerEmployee(Employee employee) {

        try {

            String query = "INSERT INTO employees(name, identityDocument, individualRegistration,"
                    + "email, phone, cellPhone, zipCode, address, number, complement, neighborhood,"
                    + "city, state, password, jobRole, accessLevel) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, employee.getName());
            prepared.setString(2, employee.getIdentityDocument());
            prepared.setString(3, employee.getIndividualRegistration());
            prepared.setString(4, employee.getEmail());
            prepared.setString(5, employee.getPhone());
            prepared.setString(6, employee.getCellPhone());
            prepared.setString(7, employee.getZipCode());
            prepared.setString(8, employee.getAddress());
            prepared.setInt(9, employee.getNumber());
            prepared.setString(10, employee.getComplement());
            prepared.setString(11, employee.getNeighborhood());
            prepared.setString(12, employee.getCity());
            prepared.setString(13, employee.getState());
            prepared.setString(14, employee.getPassword());
            prepared.setString(15, employee.getJobRole());
            prepared.setString(16, employee.getAccessLevel());

            prepared.execute();
            prepared.close();

            System.out.println("Cadastrado com sucesso!");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public List<Employee> listEmployee() {
        List<Employee> dataEmployee = new ArrayList<>();

        try {

            String query = "SELECT * FROM employees";

            prepared = connection.prepareStatement(query);
            result = prepared.executeQuery();

            while (result.next()) {
                Employee employee = new Employee();

                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setIdentityDocument(result.getString("identityDocument"));
                employee.setIndividualRegistration(result.getString("individualRegistration"));
                employee.setEmail(result.getString("email"));
                employee.setPhone(result.getString("phone"));
                employee.setCellPhone(result.getString("cellPhone"));
                employee.setZipCode(result.getString("zipCode"));
                employee.setAddress(result.getString("address"));
                employee.setNumber(result.getInt("number"));
                employee.setComplement(result.getString("complement"));
                employee.setNeighborhood(result.getString("neighborhood"));
                employee.setCity(result.getString("city"));
                employee.setState(result.getString("state"));
                employee.setPassword(result.getString("password"));
                employee.setJobRole(result.getString("jobRole"));
                employee.setAccessLevel(result.getString("accessLevel"));

                dataEmployee.add(employee);
            }
            return dataEmployee;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }

    public void changeEmployee(Employee employee) {

        try {
            String query = "UPDATE employees SET name = ?, identityDocument = ?, individualRegistration = ?,"
                    + "email = ?, phone = ?, cellPhone = ?, zipCode = ?, address = ?, number = ?,"
                    + "complement = ?, neighborhood = ?, city = ?, state = ?, password = ?, jobRole = ?,"
                    + "accessLevel = ? WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setString(1, employee.getName());
            prepared.setString(2, employee.getIdentityDocument());
            prepared.setString(3, employee.getIndividualRegistration());
            prepared.setString(4, employee.getEmail());
            prepared.setString(5, employee.getPhone());
            prepared.setString(6, employee.getCellPhone());
            prepared.setString(7, employee.getZipCode());
            prepared.setString(8, employee.getAddress());
            prepared.setInt(9, employee.getNumber());
            prepared.setString(10, employee.getComplement());
            prepared.setString(11, employee.getNeighborhood());
            prepared.setString(12, employee.getCity());
            prepared.setString(13, employee.getState());
            prepared.setString(14, employee.getPassword());
            prepared.setString(15, employee.getJobRole());
            prepared.setString(16, employee.getAccessLevel());

            prepared.setInt(17, employee.getId());

            prepared.execute();
            prepared.close();

            System.out.println("Cliente alterado com sucesso");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public void deleteEmployee(Employee employee) {

        try {
            String query = "DELETE FROM employees WHERE id = ?";

            prepared = connection.prepareStatement(query);
            prepared.setInt(1, employee.getId());

            prepared.execute();
            prepared.close();

            System.out.println("Excluido com sucesso!");
        } catch (SQLException err) {
            System.out.println("Erro: " + err);
        }
    }

    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> dataEmployee = new ArrayList<>();

        try {
            String query = "SELECT * FROM employees WHERE name LIKE ?";
            prepared = connection.prepareStatement(query);
            prepared.setString(1, "%" + name + "%");

            result = prepared.executeQuery();

            while (result.next()) {
                Employee employee = new Employee();

                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setIdentityDocument(result.getString("identityDocument"));
                employee.setIndividualRegistration(result.getString("individualRegistration"));
                employee.setEmail(result.getString("email"));
                employee.setPhone(result.getString("Phone"));
                employee.setCellPhone(result.getString("cellPhone"));
                employee.setZipCode(result.getString("zipCode"));
                employee.setAddress(result.getString("address"));
                employee.setNumber(result.getInt("number"));
                employee.setComplement(result.getString("complement"));
                employee.setNeighborhood(result.getString("neighborhood"));
                employee.setCity(result.getString("city"));
                employee.setState(result.getString("state"));
                employee.setPassword(result.getString("password"));
                employee.setJobRole(result.getString("jobRole"));
                employee.setAccessLevel(result.getString("AccessLevel"));

                dataEmployee.add(employee);
            }
            return dataEmployee;

        } catch (SQLException err) {
            System.out.println("Erro: " + err);
            return null;
        }
    }
}
