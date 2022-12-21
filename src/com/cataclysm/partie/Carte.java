package com.cataclysm.partie;



import com.cataclysm.initialisation.BuilderCarte;
import com.cataclysm.initialisation.ThemeAbstrait;
import com.cataclysm.initialisation.CarteGenere;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Carte {

    ArrayList<Composant> listePersonnage;
    int tailleX;
    int tailleY;
    ArrayList<ArrayList<PriorityQueue<Composant>>> matriceObj;

    public Carte(BuilderCarte builder) {

        ThemeAbstrait theme = builder.getTheme();
        CarteGenere carteGen = builder.getCarteGenere();
        matriceObj = new ArrayList<>();
        listePersonnage=new ArrayList<>();
        tailleX= builder.getTailleCarte()[0];
        tailleY= builder.getTailleCarte()[1];
        for (int y = 0; y < tailleY; y++) {
            matriceObj.add(new ArrayList<>());
            for (int x = 0; x <tailleX; x++) {
                matriceObj.get(y).add(new PriorityQueue<>(comparePrioriteAffiche));
                char c = carteGen.getCharCarteGen(x, y);
                if (c == 'M') { // champignon toxique
                    matriceObj.get(y).get(x).add(theme.creerChampignonToxique(x, y));
                }
                if (c == 'C') { //champignon comestible
                    matriceObj.get(y).get(x).add(theme.creerChampignonCom(x, y));
                }
                if (c == 'A') { // arbre general
                    matriceObj.get(y).get(x).add(theme.creerArbre(x, y));
                }
                if (c == 'B') { // buisson
                    matriceObj.get(y).get(x).add(theme.creerBuisson(x, y));
                }
                if (c == 'G') { //aliment
                    matriceObj.get(y).get(x).add(theme.creerAliment(x, y));
                }
                if (c == 'R') { //predateur
                    Predateur predateur = theme.creerPredateur(x, y);
                    matriceObj.get(y).get(x).add(predateur);
                    listePersonnage.add(predateur);
                }
                if (c == 'E') { //animal mignon
                    AnimalMignon mignon = theme.creerAnimalMignon(x, y);
                    matriceObj.get(y).get(x).add(mignon);
                    listePersonnage.add(mignon);
                }
                if (c == '@') { //joueur
                    Joueur joueur = builder.getJoueur();
                    joueur.setPosition(x, y);
                    listePersonnage.add(joueur);
                    matriceObj.get(y).get(x).add(joueur);
                }
            }
        }
        listePersonnage.sort(comparePersonnage);
        // A EFFACER APRES JUSTE POUR TEST
        System.out.println(listePersonnage);
    }

    Comparator<Composant> comparePersonnage = (o1, o2) -> {
        if (o1 instanceof Joueur) {
            return -1;
        } else if (o2 instanceof Joueur) {
            return 1;
        } else if (o1 instanceof Predateur && o2 instanceof AnimalMignon) {
            return 1;
        } else if (o1 instanceof AnimalMignon && o2 instanceof Predateur) {
            return -1;
        } else {
            return 0;
        }
    };

    Comparator<Composant> comparePrioriteAffiche = (o1, o2) -> {
        if (o1 instanceof Joueur) {
            return -1;
        } else if (o2 instanceof Joueur) {
            return 1;
        } else if (o1 instanceof Buisson && o2 instanceof Predateur) {
            return -1;
        } else if (o1 instanceof Predateur && o2 instanceof Buisson) {
            return 1;
        } else if (o1 instanceof Arbre || o1 instanceof Buisson) {
            return 1;
        } else if (o2 instanceof Arbre || o2 instanceof Buisson) {
            return -1;
        } else {
            return 0;
        }
    };



    public String toString(){
        String texte="";
        for(int y=0;y<tailleY;y++){
            texte+="\n";
            for(int x=0;x<tailleX;x++){
                Queue<Composant> objets=matriceObj.get(y).get(x);
                if(objets.size()==1 || objets.peek() instanceof AnimalMignon){
                    // quand il n'y a qu'un seul element dans la queue on l'affiche direct
                    // si le 1er element est un animal mignon on l'affiche direct aussi car les changements de couleurs
                    // vont se faire dans l'etat de l'animal mignon
                    texte+=objets.peek().toString()+' ';
                }
                else if(objets.isEmpty()){
                    texte+="  ";
                }
               else{
                    // sinon il y 2 elements dans la meme case : predateur et buisson ou arbre
                    // donc on affiche le buisson ou l'arbre d'un certain couleur;
                   texte+=Couleur.ANSI_PURPLE_BACKGROUND+Couleur.ANSI_WHITE+objets.peek().toString()+Couleur.ANSI_RESET+" ";

                }
            }
        }
        return texte;
    }






}
