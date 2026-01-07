package org.example.Class;

import java.time.LocalDate;

public class Commande {
    private long idCommande;
    private LocalDate dateCommande;
    private String status;
    private Integer montantTotal;
    private Utilisateur utilisateur;
    private Client client;

    public Commande(long idCommande, LocalDate dateCommande, String status, Integer montantTotal, Utilisateur utilisateur, Client client) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.status = status;
        this.montantTotal = montantTotal;
        this.utilisateur = utilisateur;
        this.client = client;
    }

    public Commande(LocalDate dateCommande, String status, Integer montantTotal, Utilisateur utilisateur, Client client) {
        this.dateCommande = dateCommande;
        this.status = status;
        this.montantTotal = montantTotal;
        this.utilisateur = utilisateur;
        this.client = client;
    }

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Integer montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + idCommande +
                ", dateCommande=" + dateCommande +
                ", status='" + status + '\'' +
                ", montantTotal=" + montantTotal +
                ", utilisateur=" + utilisateur +
                ", client=" + client +
                '}';
    }
}
