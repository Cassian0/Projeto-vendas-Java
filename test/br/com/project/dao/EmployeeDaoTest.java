package br.com.project.dao;

import br.com.project.model.Employee;
import java.util.List;
import org.junit.Test;

public class EmployeeDaoTest {

    private Employee employee;
    private EmployeeDao employeeDao;
    private List<Employee> dataEmployee;

    public EmployeeDaoTest() {
        employeeDao = new EmployeeDao();
    }

//    @Test
    public void testRegisterEmployee() {
        System.out.println("Cadastrar:");
        employee = returnEmployee();
        employeeDao.registerEmployee(employee);

    }

//    @Test
    public void testListEmployee() {
        System.out.println("Listar Todos:");
        dataEmployee = employeeDao.listEmployee();
        for (Employee employee1 : dataEmployee) {
            System.out.println("ID: " + employee1.getId());
            System.out.println("Nome: " + employee1.getName());
            System.out.println("RG: " + employee1.getIdentityDocument());
            System.out.println("CPF: " + employee1.getIndividualRegistration());
            System.out.println("Email: " + employee1.getEmail());
            System.out.println("Telefone: " + employee1.getPhone());
            System.out.println("Celular: " + employee1.getCellPhone());
            System.out.println("CEP: " + employee1.getZipCode());
            System.out.println("Endereço: " + employee1.getAddress());
            System.out.println("Numero: " + employee1.getNumber());
            System.out.println("Complemento: " + employee1.getComplement());
            System.out.println("Bairro: " + employee1.getNeighborhood());
            System.out.println("Cidade: " + employee1.getCity());
            System.out.println("Estado: " + employee1.getState());
            System.out.println("Senha: " + employee1.getPassword());
            System.out.println("Cargo: " + employee1.getJobRole());
            System.out.println("Nivel de Acesso: " + employee1.getAccessLevel());
            System.out.println();
        }

    }

//    @Test
    public void testChangeEmployee() {
        System.out.println("Alterar Funcionario:");
        int id = 0;
        employee = returnEmployee();
        employeeDao.changeEmployee(employee);

    }

//    @Test
    public void testDeleteEmployee() {
        System.out.println("Deletar Funcionario:");
        int id = 0;
        employee = new Employee();
        employee.setId(id);
        employeeDao.deleteEmployee(employee);

    }

//    @Test
    public void testSearchEmployeeByName() {
        System.out.println("Pesquisar funcionário por nome:");
        String name = "";
        dataEmployee = employeeDao.searchEmployeeByName(name);
        for (Employee employee1 : dataEmployee) {
            System.out.println("ID: " + employee1.getId());
            System.out.println("Nome: " + employee1.getName());
            System.out.println("RG: " + employee1.getIdentityDocument());
            System.out.println("CPF: " + employee1.getIndividualRegistration());
            System.out.println("Email: " + employee1.getEmail());
            System.out.println("Telefone: " + employee1.getPhone());
            System.out.println("Celular: " + employee1.getCellPhone());
            System.out.println("CEP: " + employee1.getZipCode());
            System.out.println("Endereço: " + employee1.getAddress());
            System.out.println("Numero: " + employee1.getNumber());
            System.out.println("Complemento: " + employee1.getComplement());
            System.out.println("Bairro: " + employee1.getNeighborhood());
            System.out.println("Cidade: " + employee1.getCity());
            System.out.println("Estado: " + employee1.getState());
            System.out.println("Senha: " + employee1.getPassword());
            System.out.println("Cargo: " + employee1.getJobRole());
            System.out.println("Nivel de Acesso: " + employee1.getAccessLevel());
            System.out.println();

        }
    }

    public Employee returnEmployee() {
        employee = new Employee();
        employee.setName("tiago");
        employee.setIdentityDocument("12345678");
        employee.setIndividualRegistration("55555555");
        employee.setEmail("tiago@test");
        employee.setPhone("1111111");
        employee.setCellPhone("333333333");
        employee.setZipCode("88123333");
        employee.setAddress("estrada de chão");
        employee.setNumber(15);
        employee.setComplement("barraco");
        employee.setNeighborhood("isolado");
        employee.setCity("caipiracity");
        employee.setState("estado dos loucos");
        employee.setPassword("0000000");
        employee.setJobRole("estagiario");
        employee.setAccessLevel("basico");

        employee.setId(0);

        return employee;
    }
}
