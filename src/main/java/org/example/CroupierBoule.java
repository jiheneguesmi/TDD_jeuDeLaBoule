package org.example;

import java.util.Random;

public class CroupierBoule {
    private Random random;

    // Constructeur par défaut
    public CroupierBoule() {
        this.random = new Random();
    }

    // Méthode qui retourne un numéro aléatoire entre 1 et 9 (inclus)
    public int getNumSorti() {
        return random.nextInt(9) + 1; // Génère un entier entre 1 et 9
    }
}
