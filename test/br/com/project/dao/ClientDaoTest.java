package br.com.project.dao;

import br.com.project.model.Client;
import java.util.List;
import org.junit.Test;

public class ClientDaoTest {

    private ClientDao clientDao;
    private Client client;
    private List<Client> dataClient;

    public ClientDaoTest() {
        clientDao = new ClientDao();
    }

//    @Test
    public void testRegisterClient() {
        System.out.println("Cadastrar:");
//        client = returnClient();
        clientDao.registerClient(client);
    }

//    @Test
    public void testListClients() {
        System.out.println("Listar Todos:");
        dataClient = clientDao.listClients();
        for (Client client1 : dataClient) {
            System.out.println("ID: " + client1.getId());
            System.out.println("Nome: " + client1.getName());
            System.out.println("RG: " + client1.getIdentityDocument());
            System.out.println("CPF: " + client1.getIndividualRegistration());
            System.out.println("Email: " + client1.getEmail());
            System.out.println("Telefone: " + client1.getPhone());
            System.out.println("Celular: " + client1.getCellPhone());
            System.out.println("Endereço: " + client1.getAddress());
            System.out.println("CEP: " + client1.getZipCode());
            System.out.println("Numero: " + client1.getNumber());
            System.out.println("Complemento: " + client1.getComplement());
            System.out.println("Bairro: " + client1.getNeighborhood());
            System.out.println("Cidade: " + client1.getCity());
            System.out.println("Estado: " + client1.getState());
            System.out.println();
        }
    }

//    @Test
    public void testChangeClient() {
        System.out.println("Alterar Cliente:");
        int id = 0;
        client = returnClient(id);
        clientDao.changeClient(client);
    }

//    @Test
    public void testDeleteClient() {
        System.out.println("Daletar Cliente:");
        int id = 0;
        client = new Client();
        client.setId(id);
        clientDao.deleteClient(client);
    }

//    @Test
    public void testSearchClientByName() {
        System.out.println("Pesquisar Cliente por Nome:");
        String name = "";
        dataClient = clientDao.searchClientByName(name);
        for (Client client1 : dataClient) {
            System.out.println("ID: " + client1.getId());
            System.out.println("Nome: " + client1.getName());
            System.out.println("RG: " + client1.getIdentityDocument());
            System.out.println("CPF: " + client1.getIndividualRegistration());
            System.out.println("Email: " + client1.getEmail());
            System.out.println("Telefone: " + client1.getPhone());
            System.out.println("Celular: " + client1.getCellPhone());
            System.out.println("Endereço: " + client1.getAddress());
            System.out.println("CEP: " + client1.getZipCode());
            System.out.println("Numero: " + client1.getNumber());
            System.out.println("Complemento: " + client1.getComplement());
            System.out.println("Bairro: " + client1.getNeighborhood());
            System.out.println("Cidade: " + client1.getCity());
            System.out.println("Estado: " + client1.getState());
            System.out.println();
        }
    }

    public Client returnClient(int id) {
        client = new Client();
        client.setName("joao");
        client.setIdentityDocument("1245789");
        client.setIndividualRegistration("111111111");
        client.setEmail("test@test");
        client.setPhone("999999999");
        client.setCellPhone("88888888888");
        client.setAddress("rua sem saida");
        client.setZipCode("88812323");
        client.setNumber(10);
        client.setComplement("casa");
        client.setNeighborhood("Centro");
        client.setCity("Sem volta");
        client.setState("test");
//        client.setId(id);

        return client;
    }
}
