import java.util.Scanner;

public class Main {
    private static String saisie;

    public static void main(String[] args) throws Exception {
        // appel de la classe static getInstance

        /*
         * 1) afficher le mot en masquant les lettres non trouvees par un _ et afficher
         * les lettres trouvées 2) lire la lettre de l'utilisateur
         */

        Partie.getinstancePartie().nouvellePartie();
        // test mot aleatoire
        System.out.println(Partie.getinstancePartie().get_monJeu().get_motCourant());

        do {
            afficheMotMystere();
            saisieUtilisateur();
            ResultatJoue r = Partie.getinstancePartie().joue(saisie);
            switch (r) {
                case LettreUtilisee :
                    System.out.println("Lettre déja utilisée ");
                    break;
                case LettreTrouvee:
                    System.out.println("Lettre trouvée ! ");
                    break;
                case JoueurPerd:
                    System.out.println("Vous avez perdu une vie !! ");
        }

    } while (!Partie.getinstancePartie().isFini());
        if(Partie.getinstancePartie().get_monJoueur().isPendu()) {
            System.out.println("Vous avez perdu ! il fallait trouver "+
            Partie.getinstancePartie().get_monJeu().get_motCourant());
        }else {
            System.out.println("Vous avez gagné, vous avez trouvé le mot "+
            Partie.getinstancePartie().get_monJeu().get_motCourant());
        }

    }

    private static void afficheMotMystere() {
        String texte = "";
        String mot = Partie.getinstancePartie().get_monJeu().get_motCourant();
        for (int i = 0; i < Partie.getinstancePartie().get_monJeu().get_motCourant().length(); i++) {
            char c = mot.charAt(i);
            // System.out.println(c);
            if (!Partie.getinstancePartie().get_monJeu().isLettreTrouvee(Character.toString(c))) {
                texte += "_ ";
            } else {
                texte += Character.toString(c) + " ";
            }

        }
        System.out.println(texte);
    }

    private static void saisieUtilisateur() {
        Scanner sc = new Scanner(System.in);

        saisie = sc.nextLine();
        System.out.println(saisie);
 
    }
   
}
