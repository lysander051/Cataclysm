package com.cataclysm.initialisation;
import  com.cataclysm.partie.*;

public class ThemeForet extends ThemeAbstrait{
    @Override
    public AnimalMignon creerAnimalMignon(int x, int y) {
        return new Ecureil(x,y);
    }

    @Override
    public Arbre creerArbre(int x, int y) {
        return new Arbre(x,y);
    }

    @Override
    public Aliment creerAliment(int x, int y) {
        return new Gland(x,y);
    }

    @Override
    public Predateur creerPredateur(int x, int y) {
        return new Renard(x,y);
    }
}
