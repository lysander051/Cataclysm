package com.cataclysm.initialisation;

import com.cataclysm.partie.Joueur;
import com.cataclysm.partie.Carte;

public class BuilderCarte {
    ThemeAbstrait theme;
    final CarteGenere carteGenere;
    final Joueur joueur;
    int x;
    int y;

    public BuilderCarte(CarteGenere carteGenere){
        this.carteGenere = carteGenere;
        this.joueur = new Joueur();
        setTaille();
    }

    public int[] getTailleCarte() {
        return new int[]{x,y};
    }


    private void setTaille(){
        int[] taille = carteGenere.getTaille();
        x = taille[0];
        y = taille[1];
    }

    public BuilderCarte theme(ThemeAbstrait theme){
        this.theme =theme;
        return this;
    }

    public Carte build(){
        return new Carte(this);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public ThemeAbstrait getTheme() {
        return theme;
    }

    public CarteGenere getCarteGenere() {
        return carteGenere;
    }

    @Override
    public String toString() {
        return carteGenere.toString();
    }
}
