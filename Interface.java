package simulateurzytho;

import java.util.ArrayList;
import java.util.List;

/**
 * CLASSE INTERFACE
 * ================
 * Cette classe permet de gérer les différentes interfaces de l'application.
 * Ce n'est pas une classe d'affichage graphique mais d'organisation.
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - 
 * Méthodes  : - 
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1
 */
public class Interface{

    /**
     * Nom de l'interface
     */
    private final String nom;
    
    /**
     * Raccourcis pour accéder à l'interface : lettre entrée par l'utilisateur
     */
    private final char raccourcis;
    
    /**
     * Petite phrase d'instruction pour l'affichage de la navigation
     */
    private final String legende;
    
    /**
     * Interface parent (retour en arrière) 
     */
    private final Interface parent;
    
    /**
     * Liste des interfaces enfants (avancer dans la navigation)
     */
    private List<Interface> enfants = new ArrayList<>();

    /**
     * CONSTRUCTEUR INTERFACE
     * ======================
     * Permet de construire la classe
     * 
     * ENTREES
     * =======
     * @param nom
     *          Nom de l'interface
     * @param raccourcis
     *          Raccourcis pour accéder à l'interface : lettre entrée par l'utilisateur
     * @param legende
     *          Petite phrase d'instruction pour l'affichage de la navigation
     * @param parent
     *          Interface parent (retour en arrière) 
     * @param enfants 
     *          Liste des interfaces enfants (avancer dans la navigation)
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Interface(String nom, char raccourcis, String legende, Interface parent, List<Interface> enfants){
        this.nom = nom;
        this.raccourcis = raccourcis;
        this.legende = legende;
        this.parent = parent;
        this.enfants = enfants;
    }

    /**
     * ASSESSEUR GET_NOM
     * =================
     * Retourne le nom de l'interface
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le nom de l'interface
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * ASSESSEUR GET_RACCOURCIS
     * ========================
     * Retourne le char correspondant à l'entrée que l'utilisateur doit écrire
     * pour accéder à l'interface
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le raccourcis utilisateur sous forme d'un char
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public char getRaccourcis(){
        return raccourcis;
    }
    
    /**
     * ASSESSEUR GET_LEGENDE
     * =====================
     * Retourne la légende utilisée pour construire la navigation
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le légende de navigation
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getLegende(){
        return legende;
    }
    
    /**
     * ASSESSEUR GET_ENFANTS
     * =====================
     * Retourne l'intégralité de la navigation (les enfants) sous forme 
     * d'un string déjà formaté
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Un string formaté des enfants pour la navifation "[raccourcis] Légende [rac..."
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getEnfants(){
        
        String output = "";
        
        for (Interface tmp : enfants) {
            output += "[" + tmp.getRaccourcis() + "] " + tmp.getLegende() + " ";
        }
        
        return output;
    }
    
    /**
     * MUTATEUR SET_ENFANTS
     * ====================
     * Ajoute un nouvel élément à la liste des enfants d'un élément
     * 
     * ENTREES
     * =======
     * @param nouvelEnfant 
     *          Nouvel élément enfant comme référence pour l'arbre
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setEnfants(Interface nouvelEnfant){
        this.enfants.add(nouvelEnfant);
    }
    /**
     * MUTATEUR SET_ENFANTS
     * ====================
     * Ajoute un nouvel élément à la liste des enfants d'un élément
     * Classe surchargée
     * @see {@link #setEnfants(Interface)}
     * 
     * ENTREES
     * =======
     * @param nouveauxEnfants 
     *          Nouveaux éléments enfant sous forme d'une liste comme référence pour l'arbre
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setEnfants(List<Interface> nouveauxEnfants){
        this.enfants.addAll(nouveauxEnfants);
    }

}
