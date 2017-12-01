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
    
    /**
     * Génération de l'interface d'accueil
     */
    private static Interface ACCUEIL;
    
    /**
     * Génération de l'interface de gestion des stocks
     */
    private static Interface STOCKS;
    
    /**
     * Génération de l'interface de la gestion des comptes en banque
     */
    private static Interface COMPTES;
    
    /**
     * Génération de l'interface de la gestion du personnel (barman, serveur, patron)
     */
    private static Interface PERSONNEL;
    
    /**
     * Génération de l'interface contenant la liste des clients et de sa gestion
     */
    private static Interface CLIENTS;    
    
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
        
        // Génération des interfaces
        makeInterface();
        
        // Affichage de l'écran d'accueil
        Integer[] statistiques = {20, 2500, 52, 6, 20};
        AffichageGraphique.affichageInterface(
                ACCUEIL,
                statistiques);
        
    }
    
    /**
     * METHODE MAKE_INTERFACE
     * ======================
     * Cette méthode permet de générer les différentes interfaces puis de les 
     * liers avec un lien en arbre parents-enfants
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void makeInterface(){
        ACCUEIL   = new Interface("Accueil du Zytho", 'R', "Retourner à l'accueil", "planZytho", null, null);
        STOCKS    = new Interface("Affichage des stocks", 'S', "Stocks", null, ACCUEIL, null);
        COMPTES   = new Interface("Affichage du compte en banque", 'C', "Comptes", null, ACCUEIL, null);
        PERSONNEL = new Interface("Gestion du personnel", 'G', "Gestion personnel", null, ACCUEIL, null);
        CLIENTS   = new Interface("Gestion des clients présents dans le bar", 'L', "Liste clients", null, ACCUEIL, null);
        
        ACCUEIL.setEnfants(new Interface[]{STOCKS, COMPTES, PERSONNEL, CLIENTS});
        STOCKS.setEnfants(new Interface[]{ACCUEIL});
        COMPTES.setEnfants(new Interface[]{ACCUEIL});
        PERSONNEL.setEnfants(new Interface[]{ACCUEIL});
        CLIENTS.setEnfants(new Interface[]{ACCUEIL});
    }  
    
}
