package com.cataclysm;

import com.cataclysm.initialisation.BuilderCarte;
import com.cataclysm.initialisation.CarteAleatoire;
import com.cataclysm.initialisation.CarteImporte;

import java.io.File;

public class Controleur {
    Ihm ihm;
    BuilderCarte builderCarte;

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

        System.out.println(builderCarte);
    }
}
