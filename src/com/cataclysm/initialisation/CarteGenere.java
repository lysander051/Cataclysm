package com.cataclysm.initialisation;

import java.util.ArrayList;

public class CarteGenere {
    protected int x;
    protected int y;
    protected ArrayList<ArrayList<Character>> carte;

    public int[] getTaille(){
        return new int[]{x,y};
    }

    @Override
    public String toString() {
        String texte = null;
        for (int i = 0; i < y; i++) {
            texte += "\n";
            for (int j = 0; j < x; j++) {
                texte += carte.get(i).get(j).toString() + ' ';
            }
        }
        return texte;
    }
}
