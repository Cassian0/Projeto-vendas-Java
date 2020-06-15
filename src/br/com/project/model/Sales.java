package br.com.project.model;

public class Sales {

    private int id;
    private Client client;
    private String DateSale;
    private double totalVenda;
    private String note; // Observação

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDateSale() {
        return DateSale;
    }

    public void setDateSale(String DateSale) {
        this.DateSale = DateSale;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
