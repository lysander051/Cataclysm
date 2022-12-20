package com.cataclysm;

import java.util.Scanner;

public class Ihm {

    public int bienvenue(){
        Scanner scanner = new Scanner(System.in);
        int choix;

        System.out.println("\n\nBienvenue sur cataclysm\n");
        System.out.println("Comment voulez vous initialiser votre partie?");
        System.out.println("1 - Carte aléatoire");
        System.out.println("2 - Carte importé");
        choix = scanner.nextInt();
        return choix;
    }

    public boolean setTailleCarte(){
        Scanner scanner = new Scanner(System.in);
        int choix;

        System.out.println("\n\n voulez vous choisir une taille de carte ou laisser la taille par defautl?");
        System.out.println("1 - choisir la taille");
        System.out.println("2 - taille par default");
        choix = scanner.nextInt();

        return choix == 1;
    }

    public int[] tailleCarte(){
        int[] taille = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nQuelle taille fera votre carte?");
        System.out.println("taille en x");
        taille[0] = scanner.nextInt();
        System.out.println("taille en y");
        taille[1] = scanner.nextInt();

        scanner.close();
        return taille;
    }
}
