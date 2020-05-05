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
        int id = 2;
        client = returnClient(id);
        clientDao.changeClient(client);
    }

//    @Test
    public void testDeleteClient() {
        System.out.println("Daletar Cliente:");
        int id = 1;
        client = new Client();
        client.setId(id);   
        clientDao.deleteClient(client);
    }

//    @Test
    public void testSearchClientByName() {
        System.out.println("Pesquisar Cliente por Nome:");
        String name = "j";
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
        client.setName("Maria");
        client.setIdentityDocument("5555555");
        client.setIndividualRegistration("222222");
        client.setEmail("test@@@@");
        client.setPhone("77777777");
        client.setCellPhone("6666666666");
        client.setAddress("rua");
        client.setZipCode("000000000");
        client.setNumber(25);
        client.setComplement("ca");
        client.setNeighborhood("bairro");
        client.setCity("Sei la");
        client.setState("tu");
        client.setId(id);

        return client;
    }
}
