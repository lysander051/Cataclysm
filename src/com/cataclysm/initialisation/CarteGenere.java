package com.cataclysm.initialisation;

import java.util.ArrayList;

public class CarteGenere {
    protected int x;
    protected int y;
    protected ArrayList<ArrayList<Character>> carte;

    public int[] getTaille(){
        return new int[]{x,y};
    }
}
