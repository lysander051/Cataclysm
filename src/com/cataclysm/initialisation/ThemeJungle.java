package com.cataclysm.initialisation;
import com.cataclysm.partie.*;

public class ThemeJungle extends ThemeAbstrait{
    @Override
    public AnimalMignon creerAnimalMignon(int x, int y) {
        return new Singe(x,y);
    }

    @Override
    public Arbre creerArbre(int x, int y) {
        return new Cocotier(x,y);
    }

    @Override
    public Aliment creerAliment(int x, int y) {
        return new Banane(x,y);
    }

    @Override
    public Predateur creerPredateur(int x, int y) {
        return new Serpent(x,y);
    }
}
