package com.example.tp_note_java;

public class pizza {
    //private int id;
    private String nom;
    private int prix;
    private int nbIngredients;

    public pizza(String nom, int prix, int nbIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbIngredients() {
        return nbIngredients;
    }

    public void setNbIngredients(int nbIngredients) {
        this.nbIngredients = nbIngredients;
    }

    @Override
    public String toString() {
        return "pizza{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nbIngredients=" + nbIngredients +
                '}';
    }
}
