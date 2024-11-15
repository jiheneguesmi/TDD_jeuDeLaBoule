package org.example;

public class Joueur {
    private String nom;
    private int solde;
    private CroupierBoule croupier; // Le mock lors des tests
    //constructeur initialise un objet de la classe Joueur
    public Joueur(String nom, int solde, CroupierBoule croupier) {
        this.nom = nom;
        this.solde = solde;
        this.croupier = croupier;
    }
    public String getNom() {
        return nom;
    }
    //renvoie le solde actuel du joueur
    public int getSolde() {
        return solde;
    }
    //Cette méthode permet au joueur de miser un montant spécifique sur un numéro précis (compris entre 1 et 9)
    /*Si le joueur a assez d'argent (le montant de la mise ne doit pas dépasser son solde), il mise sur un numéro.
La méthode demande au croupier (via croupier.getNumSorti()) quel numéro est sorti.
Si le numéro misé par le joueur est le même que le numéro sorti, le joueur gagne 7 fois sa mise et cette somme est ajoutée à son solde.
Si le joueur perd, la somme misée est déduite de son solde.*/
    public void miserSurNumero(int numero, int montant) {
        if (montant <= solde) {
            int numeroSorti = croupier.getNumSorti();
            if (numeroSorti == numero) {
                solde += 7 * montant; // Le joueur gagne 7 fois la mise
            } else {
                solde -= montant; // Le joueur perd la mise
            }
        }
    }
    /*Le joueur spécifie une catégorie (chance simple:rouge, noir, pair, impair, manque, ou passe) sur laquelle il veut miser, ainsi qu'un montant.
    Si le joueur a assez d'argent pour couvrir la mise, la méthode demande au croupier quel numéro est sorti.
En fonction du numéro sorti et de la chance simple sur laquelle le joueur a misé, la méthode vérifie si le joueur a gagné ou perdu.
Si le joueur a gagné, son solde est augmenté du montant misé (puisqu'il récupère sa mise et gagne le même montant).
Si le joueur a perdu, le montant misé est déduit de son solde.
     */
    public void miserSurChanceSimple(String type, int montant) {
        if (montant <= solde) {
            int numeroSorti = croupier.getNumSorti();

            boolean gagne = false;

            switch (type.toLowerCase()) {
                case "rouge":
                    gagne = estRouge(numeroSorti);
                    break;
                case "noir":
                    gagne = estNoir(numeroSorti);
                    break;
                case "pair":
                    gagne = estPair(numeroSorti);
                    break;
                case "impair":
                    gagne = estImpair(numeroSorti);
                    break;
                case "manque":
                    gagne = estManque(numeroSorti);
                    break;
                case "passe":
                    gagne = estPasse(numeroSorti);
                    break;
                default:
                    System.out.println("Type de pari inconnu.");}
            if (gagne) {
                solde += montant; // Le joueur gagne, donc on lui restitue la mise
            } else {
                solde -= montant; // Le joueur perd la mise
            }
        }


    }

    private boolean estRouge(int numero) {
        return numero == 2 || numero == 4 || numero == 7 || numero == 9;
    }

    private boolean estNoir(int numero) {
        return numero == 1 || numero == 3 || numero == 6 || numero == 8;
    }

    private boolean estPair(int numero) {
        return numero == 2 || numero == 4 || numero == 6 || numero == 8;
    }

    private boolean estImpair(int numero) {
        return numero == 1 || numero == 3 || numero == 7 || numero == 9;
    }

    private boolean estManque(int numero) {
        return numero >= 1 && numero <= 4;
    }

    private boolean estPasse(int numero) {
        return numero >= 6 && numero <= 9;
    }
    }





