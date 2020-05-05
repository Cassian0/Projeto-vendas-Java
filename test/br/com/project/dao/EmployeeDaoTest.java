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
//        employee = returnEmployee();
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
        int id = 1;
        employee = returnEmployee(id);
        employeeDao.changeEmployee(employee);

    }

//    @Test
    public void testDeleteEmployee() {
        System.out.println("Deletar Funcionario:");
        int id = 2;
        employee = new Employee();
        employee.setId(id);
        employeeDao.deleteEmployee(employee);

    }

//    @Test
    public void testSearchEmployeeByName() {
        System.out.println("Pesquisar funcionário por nome:");
        String name = "t";
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

    public Employee returnEmployee(int id) {
        employee = new Employee();
        employee.setName("Jonas");
        employee.setIdentityDocument("44444444");
        employee.setIndividualRegistration("00000000");
        employee.setEmail("tiago@Jonas");
        employee.setPhone("122222222");
        employee.setCellPhone("777777777");
        employee.setZipCode("88888888888");
        employee.setAddress("chão");
        employee.setNumber(20);
        employee.setComplement("casa");
        employee.setNeighborhood("centro");
        employee.setCity("city");
        employee.setState("ca");
        employee.setPassword("9999999");
        employee.setJobRole("gerente");
        employee.setAccessLevel("master");

        employee.setId(2);

        return employee;
    }
}
