package com.cataclysm.partie;

public abstract class AnimalMignon extends Composant{
    private int niveauSatiete;
    private boolean estAmi;

    public AnimalMignon(int x, int y) {
        super(x, y);
        niveauSatiete=5;
        estAmi=false;
    }
}
