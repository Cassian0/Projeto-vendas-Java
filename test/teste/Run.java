
package teste;

import br.com.project.model.Cliente;


public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(122);
        cliente.setNome("maria");
        cliente.setEmail("maria@");
        cliente.setCep("123456789");
        cliente.setBairro("sem nome");
        cliente.setCidade("São José");
        cliente.setEstado("São Paulo");
        cliente.setRg("123456777");
        cliente.setCpf("1004587845");
        cliente.setCelular("999999999");
        cliente.setTelefone("5555555");
        cliente.setComplemento("casa");
        cliente.setEndereco("Rua qualquer");
        cliente.setNumero("numero");
        
        System.out.println(cliente.toString());
    }
    
}
