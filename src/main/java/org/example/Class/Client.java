package org.example.Class;

public class Client {

    private long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;

    public Client(long idClient, String telephone, String adresse, String email, String prenom, String nom) {
        this.idClient = idClient;
        this.telephone = telephone;
        this.adresse = adresse;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getidClient() {
        return idClient;
    }

    public void setidClient(long idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
