package simulateurzytho;

/**
 * CLASSE SIMULATEUR_ZYTHO
 * =======================
 * Cette classe est la seule compilée au démarage du projet via sa classe main
 * Elle ne fait rien de particulier en elle-même mais est la liaison de toutes
 * les autres classes
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - 
 * Méthodes  : - main()
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1
 */
public class SimulateurZytho {
    
    // DEFINITIONS DES VARIABLES DU JEU
    // INTERFACES
    
    /**
     * Interface d'accueil
     */    
    private static Interface ACCUEIL   = new Interface("Accueil du Zytho", 'R', "Retourner à l'accueil", null, null);
    private static Interface STOCKS    = new Interface("Affichage des stocks", 'S', "Stocks", ACCUEIL, null);
    private static Interface COMPTES   = new Interface("Affichage du compte en banque", 'C', "Comptes", ACCUEIL, null);
    private static Interface PERSONNEL = new Interface("Gestion du personnel", 'G', "Gestion personnel", ACCUEIL, null);
    private static Interface CLIENTS   = new Interface("Gestion des clients présents dans le bar", 'L', "Liste clients", ACCUEIL, null);
    
    ACCUEIL.setEnfants(STOCKS);
    
    /**
     * METHODE MAIN
     * ============
     * Méthode principale lancée à la compilation du projet
     * 
     * ENTREES
     * =======
     * @param args
     *          Les arguments passés en entrée du projet (via la console ou autre)
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void main(String[] args) {
        
        // ETAPE 1 : affichage de l'écran d'accueil
        Integer[] statistiques = {20, 2500, 52, 6, 20};
        AffichageGraphique.affichageInterface(
                ACCUEIL,
                statistiques, 
                "planZytho");
        
    }
    
}
