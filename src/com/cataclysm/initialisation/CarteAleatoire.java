package com.cataclysm.initialisation;

public class CarteAleatoire extends CarteGenere{
    public CarteAleatoire() {
        this.x = 40;
        this.y = 100;
    }
    public CarteAleatoire(int[] tailleCarte) {
        this.x = tailleCarte[0];
        this.y = tailleCarte[1];
    }
}
