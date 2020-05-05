package br.com.project.model;

import java.io.Serializable;

public class Employee extends Client implements Serializable {

    private String jobRole; // CARGO
    private String password;
    private String accessLevel; //NIVEL DE ACESSO

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
