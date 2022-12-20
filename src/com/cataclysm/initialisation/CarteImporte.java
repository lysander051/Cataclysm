package com.cataclysm.initialisation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CarteImporte extends CarteGenere{

    public CarteImporte(File file){
        try {
            Scanner scanner = new Scanner(file);
            y = scanner.nextInt();
            x = scanner.nextInt();
            carte = new ArrayList<>(y);
            for (int i = 0; i < y; i++) {
                carte.add(new ArrayList<>());
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    for (int j = 0; j < data.length(); j++) {
                        carte.get(i).add(data.charAt(j));
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Problème avec le fichier");
            e.printStackTrace();
        }
    }
}
