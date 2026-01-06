package org.example.Class;

public class Formation {

    private Long idFormation;
    private String nom;
    private String description;
    private Integer dureeJour;
    private String typeFormation;
    private double prix;

    public Formation(Long idFormation, String nom, String description, Integer dureeJour, String typeFormation, double prix) {
        this.idFormation = idFormation;
        this.nom = nom;
        this.description = description;
        this.dureeJour = dureeJour;
        this.typeFormation = typeFormation;
        this.prix = prix;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDureeJour() {
        return dureeJour;
    }

    public void setDureeJour(Integer dureeJour) {
        this.dureeJour = dureeJour;
    }

    public String getTypeFormation() {
        return typeFormation;
    }

    public void setTypeFormation(String typeFormation) {
        this.typeFormation = typeFormation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "idFormation=" + idFormation +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dureeJour=" + dureeJour +
                ", typeFormation='" + typeFormation + '\'' +
                ", prix=" + prix +
                '}';
    }
}
