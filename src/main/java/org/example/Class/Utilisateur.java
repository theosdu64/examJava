package org.example.Class;

public class Utilisateur {

    private  Long id_utilisateur;
    private String email;
    private String password;

    public Utilisateur(Long id_utilisateur, String email, String password) {
        this.id_utilisateur = id_utilisateur;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
