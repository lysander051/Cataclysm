package com.cataclysm.initialisation;
import com.cataclysm.partie.*;

public abstract class ThemeAbstrait {
    public Champignon creerChampignonCom(int x, int y){
        return new ChampignonCom(x,y);
    }
    public Champignon creerChampignonToxique(int x,int y){
        return new ChampToxique(x,y);
    }
    public Buisson creerBuisson(int x , int y){
        return new Buisson(x,y);
    }
    public abstract AnimalMignon creerAnimalMignon(int x,int y);
    public abstract Arbre creerArbre(int x ,int y);
    public abstract Aliment creerAliment(int x , int y);
    public abstract Predateur creerPredateur(int x, int y);



}
