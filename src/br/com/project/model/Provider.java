package br.com.project.model;

import java.io.Serializable;

public class Provider extends Client implements Serializable {

    private String companyIdentificationNumber; // CNPJ 

    public String getCompanyIdentificationNumber() {
        return companyIdentificationNumber;
    }

    public void setCompanyIdentificationNumber(String companyIdentificationNumber) {
        this.companyIdentificationNumber = companyIdentificationNumber;
    }

    public String toString() {
        return this.getCompanyIdentificationNumber();
    }
}
