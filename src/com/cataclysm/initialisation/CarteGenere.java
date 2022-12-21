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
        // A EFFACER APRES JUSTE POUR LE TEST
        System.out.println("renard :  "+ nbCar('R',texte) );
        System.out.println("gentil :  "+ nbCar('E',texte) );
        return texte;
    }
    public char getCharCarteGen(int x , int y ){
        return carte.get(y).get(x);
    }

    // A EFFACER APRES JUSTE POUR LE TEST
    public int  nbCar(char a , String s){
        int n=0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == a)
                n++;
        }
        return n;

        }

}
