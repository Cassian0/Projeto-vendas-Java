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
//        provider = returnProvider();
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
        provider = returnProvider(id);
        providerDao.changeProvider(provider);
    }

//    @Test
    public void testDeleteProvider() {
        System.out.println("Deletar Fornecedor:");
        int id = 2;
        provider = new Provider();
        provider.setId(id);
        providerDao.deleteProvider(provider);

    }

//    @Test
    public void testSearchProviderByName() {
        System.out.println("Pesquisar fornecedor por nome:");
        String name = "ma";
        provider = providerDao.searchProviderByName(name);
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

    public Provider returnProvider(int id) {
        provider = new Provider();
        provider.setName("danilo");
        provider.setCompanyIdentificationNumber("00000000");
        provider.setEmail("danilo@test");
        provider.setPhone("333333333");
        provider.setCellPhone("111111111");
        provider.setAddress("hortaliças");
        provider.setZipCode("66666666");
        provider.setComplement("casa");
        provider.setNumber(333);
        provider.setNeighborhood("centro");
        provider.setCity("city");
        provider.setState("ba");

        provider.setId(2);
        return provider;
    }

}
