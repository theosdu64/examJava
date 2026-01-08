package org.example.Class;

public class ArticleCommande {
    private long idArticleCommande ;
    private Integer quantite;
    private double prixUnitaire;
    private Commande commande;
    private Formation formation;


    public ArticleCommande(long idArticleCommande, Integer quantite, double prixUnitaire, Commande commande, Formation formation) {
        this.idArticleCommande  = idArticleCommande;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.commande = commande;
        this.formation = formation;
    }

    public ArticleCommande(Integer quantite, double prixUnitaire, Formation formation) {
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.formation = formation;
    }

    public double calculerSousTotal() {
        return  quantite * prixUnitaire;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public long getIdArticleCommande() {
        return idArticleCommande;
    }

    public void setIdArticleCommande(long idArticleCommande) {
        this.idArticleCommande = idArticleCommande;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "ArticleCommande{" +
                "idArticleCommande=" + idArticleCommande +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", commande=" + commande +
                ", formation=" + (formation != null ? formation.getNom() : "null") +
                ", sousTotal=" + calculerSousTotal() +
                '}';
    }
}

