package org.example.Class;

public class Utilisateur {

    private  Long idUtilisateur;
    private String email;
    private String password;

    public Utilisateur(Long idUtilisateur, String email, String password) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(Long idUtilisateur, String email) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
    }

    public Utilisateur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setidUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
                "id_utilisateur=" + idUtilisateur +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
