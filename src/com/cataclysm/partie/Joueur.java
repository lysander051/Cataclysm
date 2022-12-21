package com.cataclysm.partie;

public class Joueur extends Composant {
    public Joueur() {
        super(0, 0);


    }

    public void setPosition(int x,int y){
        setX(x);
        setY(y);
    }

    public String toString(){
        return "@";
    }
}
