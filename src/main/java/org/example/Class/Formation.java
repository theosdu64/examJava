package org.example.Class;

public class Formation {

    private Long id_formation;
    private String nom;
    private String description;
    private Integer duree_jour;
    private type_f type_formation;
    private double prix;

    public Formation(Long id_formation, String nom, String description, Integer duree_jour, type_f type_formation, double prix) {
        this.id_formation = id_formation;
        this.nom = nom;
        this.description = description;
        this.duree_jour = duree_jour;
        this.type_formation = type_formation;
        this.prix = prix;
    }

    public Long getId_formation() {
        return id_formation;
    }

    public void setId_formation(Long id_formation) {
        this.id_formation = id_formation;
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

    public Integer getDuree_jour() {
        return duree_jour;
    }

    public void setDuree_jour(Integer duree_jour) {
        this.duree_jour = duree_jour;
    }

    public type_f getType_formation() {
        return type_formation;
    }

    public void setType_formation(type_f type_formation) {
        this.type_formation = type_formation;
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
                "id_formation='" + id_formation + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", duree_jour=" + duree_jour +
                ", type_formation=" + type_formation +
                ", prix=" + prix +
                '}';
    }
}
