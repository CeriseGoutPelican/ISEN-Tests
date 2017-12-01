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
    private Interface interfaceAccueil;
    
    /**
     * Génération de l'interface de gestion des stocks
     */
    private Interface interfaceStocks;
    
    /**
     * Génération de l'interface de la gestion des comptes en banque
     */
    private Interface interfaceComptes;
    
    /**
     * Génération de l'interface de la gestion du personnel (barman, serveur, patron)
     */
    private Interface interfacePersonnel;
    
    /**
     * Génération de l'interface contenant la liste des clients et de sa gestion
     */
    private Interface interfaceClients;
    
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
        // Affichage de l'écran d'accueil
        Integer[] statistiques = {20, 2500, 52, 6, 20};
        AffichageGraphique.affichageInterface(
                interfaceAccueil,
                statistiques, 
                "planZytho");
        
    }
    
    /**
     * CONSTRUCTEUR MAKE_INTERFACE
     * ===========================
     * Cette méthode permet de générer les différentes interfaces puis de les 
     * liers avec un lien en arbre parents-enfants
     * 
     * ENTREES
     * =======
     * @param interfaceAccueil 
     *          Interface de l'accueil
     * @param interfaceStocks 
     *          Interface de la gestion des stocks
     * @param interfaceComptes
     *          Interface de la gestion des comptes en banque
     * @param interfacePersonnel 
     *          Interface de la gestion du personnel
     * @param interfaceClients 
     *          Interface de la gestion des clients
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public SimulateurZytho(Interface interfaceAccueil, Interface interfaceStocks, Interface interfaceComptes, Interface interfacePersonnel, Interface interfaceClients){
        this.interfaceAccueil   = new Interface("Accueil du Zytho", 'R', "Retourner à l'accueil", null, null);
        this.interfaceStocks    = new Interface("Affichage des stocks", 'S', "Stocks", interfaceAccueil, null);
        this.interfaceComptes   = new Interface("Affichage du compte en banque", 'C', "Comptes", interfaceAccueil, null);
        this.interfacePersonnel = new Interface("Gestion du personnel", 'G', "Gestion personnel", interfaceAccueil, null);
        this.interfaceClients   = new Interface("Gestion des clients présents dans le bar", 'L', "Liste clients", interfaceAccueil, null);
        
        interfaceAccueil.setEnfants(new Interface[]{interfaceStocks, interfaceComptes, interfacePersonnel, interfaceClients});
    }  
    
}
