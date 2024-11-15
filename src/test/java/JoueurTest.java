import org.example.CroupierBoule;
import org.example.Joueur;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class JoueurTest {
    @Test
    public void testJoueurGagneMiseSurNumero() {
        // Création du mock pour CroupierBoule
        CroupierBoule croupierMock = mock(CroupierBoule.class);

        // Simuler que le numéro sorti est 8
        when(croupierMock.getNumSorti()).thenReturn(8);

        // Créer un joueur avec un solde initial de 100 euros
        Joueur joueur = new Joueur("Alice", 100, croupierMock);

        // Alice mise 3 jetons sur le numéro 8
        joueur.miserSurNumero(8, 3);

        // Vérifier que le solde est maintenant de 121 (100 + 3 * 7)
        assertEquals(121, joueur.getSolde(), "Le joueur devrait gagner 7 fois sa mise");
        System.out.println("Test passé avec succès : Le joueur a gagné et son solde est " + joueur.getSolde());
    }

    //2 ème test
    @Test
    public void testJoueurPerdMiseSurNumero() {
        // Création du mock pour CroupierBoule
        CroupierBoule croupierMock = mock(CroupierBoule.class);

        // Simuler que le numéro sorti est 9
        when(croupierMock.getNumSorti()).thenReturn(9);

        // Créer un joueur avec un solde initial de 100 euros
        Joueur joueur = new Joueur("Alice", 100, croupierMock);

        // Alice mise 3 jetons sur le numéro 8
        joueur.miserSurNumero(8, 3);

        // Vérifier que le solde est maintenant de 97 (100 - 3)
        assertEquals(97, joueur.getSolde(), "Le joueur devrait perdre la mise");
        System.out.println("Test passé avec succès : Le joueur a perdu et son solde est " + joueur.getSolde());

    }
}
