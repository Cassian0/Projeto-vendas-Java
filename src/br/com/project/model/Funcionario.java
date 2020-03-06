package br.com.project.model;

public class Funcionario extends Cliente {

    private String cargo;
    private String senha;
    private String nivelAcesso;

    public Funcionario() {

    }

    public Funcionario(String cargo, String senha, String nivelAcesso, Integer codigo, String nome, String email, String cep, String endereco, String bairro, String cidade, String cpf, String rg, String celular, String telefone, String numero, String complemento, String estado) {
        super(codigo, nome, email, cep, endereco, bairro, cidade, cpf, rg, celular, telefone, numero, complemento, estado);
        this.cargo = cargo;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

}
