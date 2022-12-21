package com.cataclysm.initialisation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CarteImporte extends CarteGenere{

    public CarteImporte(File file){
        try {
            Scanner scanner = new Scanner(file);
            // A REMPLACER CAR DANS LA NOUVELLE CARTE C'EST ECRIT FORET
            scanner.nextLine();
            this.y = scanner.nextInt();
            this.x = scanner.nextInt();
            scanner.nextLine();
            this.carte = new ArrayList<>();
            for (int i = 0; i < this.y; i++) {
                this.carte.add(new ArrayList<>());
                String data = scanner.nextLine();
                for (int j = 0; j < this.x; j++) {
                    if (j < data.length())
                        this.carte.get(i).add(data.charAt(j));
                    else
                        this.carte.get(i).add(' ');
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Problème avec le fichier");
            e.printStackTrace();
        }
    }
}
