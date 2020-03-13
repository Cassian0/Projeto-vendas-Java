package br.com.project.model;

import java.io.Serializable;

public class Client implements Serializable {

    protected int id;
    protected String name;
    protected String email;
    protected String zipCode; //cep
    protected String address; //endereço
    protected String neighborhood; //bairro
    protected String city;
    protected String individualRegistration;
    protected String identityDocument;
    protected String cellPhone;
    protected String phone;
    protected int number;
    protected String complement;
    protected String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return " Codigo:" + this.id + " \n Nome: " + this.name + "\n E-mail: " + this.email
                + "\n Cep: " + this.zipCode + "\n Endereço: " + this.address + "\n Bairro: " + this.neighborhood
                + "\n Cidade: " + this.city + "\n Estado: " + this.state + "\n CPF: " + this.individualRegistration + "\n RG: "
                + this.identityDocument + "\n Celular: " + this.cellPhone + "\n Telefone: " + this.phone + "\n Numero: "
                + this.number + "\n Complemento: " + this.complement;

    }

}
