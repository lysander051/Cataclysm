package com.cataclysm;

import com.cataclysm.initialisation.*;
import com.cataclysm.partie.Carte;

import java.io.File;
import java.sql.SQLOutput;

public class Controleur {
    Ihm ihm;
    BuilderCarte builderCarte;
    Carte carte;

    public Controleur(){
        this.ihm = new Ihm();
    }

    public void initialisation(){
        if(ihm.bienvenue() == 1){
            if(ihm.setTailleCarte())
                builderCarte = new BuilderCarte(new CarteAleatoire(ihm.tailleCarte()));
            else
                builderCarte = new BuilderCarte(new CarteAleatoire());
        }
        else{
            builderCarte = new BuilderCarte(new CarteImporte(new File("carte.txt")));
        }
        if(ihm.choixTheme()==1){
            builderCarte=builderCarte.theme(new ThemeForet());
        }
        else{
            builderCarte=builderCarte.theme(new ThemeJungle());
        }
        carte = builderCarte.build();
        System.out.println(" LA CARTE STRING AU DEBUT");
        System.out.println(builderCarte);
        System.out.println("LA CARTE STRING AVEC THEME");
        System.out.println(carte);
    }
}
