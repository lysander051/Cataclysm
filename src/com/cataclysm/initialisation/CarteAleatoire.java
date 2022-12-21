package com.cataclysm.initialisation;

import java.util.ArrayList;

public class CarteAleatoire extends CarteGenere{
    public CarteAleatoire() {
        this(new int[] {100,40});
    }
    public CarteAleatoire(int[] tailleCarte) {
        this.x = tailleCarte[0];
        this.y = tailleCarte[1];

        char[] objets = {'A', 'B', 'M', 'C', 'E', 'G','R'};
        double range;

        this.carte = new ArrayList<>();
        for (int i = 0; i < this.y; i++) {
            this.carte.add(new ArrayList<>());
            for (int j = 0; j < this.x; j++) {
                range = Math.random();
                if (range < .85)
                    this.carte.get(i).add(' ');
                else
                    this.carte.get(i).add(objets[(int) (Math.random() * objets.length)]);
            }
        }
    }
}
