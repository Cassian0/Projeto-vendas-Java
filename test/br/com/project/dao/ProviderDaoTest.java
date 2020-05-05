package br.com.project.dao;

import br.com.project.model.Provider;
import java.util.List;
import org.junit.Test;

public class ProviderDaoTest {

    private Provider provider;
    private ProviderDao providerDao;
    private List<Provider> dataProvider;

    public ProviderDaoTest() {
        providerDao = new ProviderDao();
    }

//    @Test
    public void testRegisterProvider() {
        System.out.println("Cadastrar:");
        provider = returnProvider();
        providerDao.registerProvider(provider);
    }

//    @Test
    public void testListProvider() {
        System.out.println("Listar Todos:");
        dataProvider = providerDao.listProvider();
        for (Provider provider1 : dataProvider) {
            System.out.println("ID: " + provider1.getId());
            System.out.println("Nome: " + provider1.getName());
            System.out.println("RG: " + provider1.getCompanyIdentificationNumber());
            System.out.println("CPF: " + provider1.getEmail());
            System.out.println("Telefone: " + provider1.getPhone());
            System.out.println("Celular: " + provider1.getCellPhone());
            System.out.println("CEP: " + provider1.getZipCode());
            System.out.println("Endereço: " + provider1.getAddress());
            System.out.println("Complemento: " + provider1.getComplement());
            System.out.println("Numero: " + provider1.getNumber());
            System.out.println("Bairro: " + provider1.getNeighborhood());
            System.out.println("Cidade: " + provider1.getCity());
            System.out.println("Estado: " + provider1.getState());
            System.out.println();
        }
    }

//    @Test
    public void testChangeProvider() {
        System.out.println("Alterar Fornecedor:");
        int id = 0;
        provider = returnProvider();
        providerDao.changeProvider(provider);
    }

//    @Test
    public void testDeleteProvider() {
        System.out.println("Deletar Fornecedor:");
        int id = 0;
        provider = new Provider();
        provider.setId(id);
        providerDao.deleteProvider(provider);

    }

//    @Test
    public void testSearchProviderByName() {
        System.out.println("Pesquisar fornecedor por nome:");
        String name = "";
        dataProvider = providerDao.searchProviderByName(name);
        for (Provider provider1 : dataProvider) {
            System.out.println("ID: " + provider1.getId());
            System.out.println("Nome: " + provider1.getName());
            System.out.println("RG: " + provider1.getCompanyIdentificationNumber());
            System.out.println("CPF: " + provider1.getEmail());
            System.out.println("Telefone: " + provider1.getPhone());
            System.out.println("Celular: " + provider1.getCellPhone());
            System.out.println("CEP: " + provider1.getZipCode());
            System.out.println("Endereço: " + provider1.getAddress());
            System.out.println("Complemento: " + provider1.getComplement());
            System.out.println("Numero: " + provider1.getNumber());
            System.out.println("Bairro: " + provider1.getNeighborhood());
            System.out.println("Cidade: " + provider1.getCity());
            System.out.println("Estado: " + provider1.getState());
            System.out.println();
        }
    }

    public Provider returnProvider() {
        provider = new Provider();
        provider.setName("maria");
        provider.setCompanyIdentificationNumber("5555555555");
        provider.setEmail("maria@test");
        provider.setPhone("7777777");
        provider.setCellPhone("4444444444");
        provider.setAddress("rua das hortaliças");
        provider.setZipCode("8888123");
        provider.setComplement("ap");
        provider.setNumber(3);
        provider.setNeighborhood("chique");
        provider.setCity("burguesia");
        provider.setState("Ceara");

        provider.setId(0);
        return provider;
    }

}
