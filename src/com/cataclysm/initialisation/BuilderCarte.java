package com.cataclysm.initialisation;

import com.cataclysm.partie.Joueur;

public class BuilderCarte {
    final CarteGenere carteGenere;
    final Joueur joueur;
    int x;
    int y;

    public BuilderCarte(CarteGenere carteGenere){
        this.carteGenere = carteGenere;
        this.joueur = new Joueur();
        setTaille();
    }

    private void setTaille(){
        int[] taille = carteGenere.getTaille();
        x = taille[0];
        y = taille[1];
    }
}
