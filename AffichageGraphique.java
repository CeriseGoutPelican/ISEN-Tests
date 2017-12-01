package simulateurzytho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CLASSE AFFICHAGEGRAPHIQUE
 * =========================
 * Cette classe regroupe les éléments de l'interface graphique du simulateur
 * incluant les dessins en ASCII pour une facilité et une aisance d'utiliation
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - 
 * Méthodes  : -
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class AffichageGraphique {
    
    // Gestion des couleurs pour la console
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    /**
     * METHODE PRESS_ANY_KEY_TO_CONTINUE
     * =================================
     * Cette méthode permet de changer d'interface en appuyant sur n'importe
     * quelle touche du clavier
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void pressAnyKeyToContinue()
    { 
           System.out.println(" Appuyez sur une touche pour continuer...");
           try
           {
               System.in.read();
               clearScreen();
           }  
           catch(IOException e)
           {}  
    }    
    
    /**
     * METHODE CLEAR_SCREEN
     * ====================
     * Cette méthode permet de "vider" l'écran de la console afin d'afficher
     * une nouvelle interface. L'effacement n'étant pas réellement possible, 
     * on se contente de forcer le scroll
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void clearScreen() {  
        for(int i = 0; i < 30; i++)
            System.out.println("\n");
    }

    /**
     * METHODE SEPARATION
     * ==================
     * Cette méthode permet de simplement écrire une ligne de séparation dans
     * l'interface. Elle n'a pour utilité qu'esthétique.
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void separation(){
        System.out.println("+----------------------------------------------------------------------------------------------------------------------+");
    }
    
    /**
     * METHODE LIGNES
     * ==============
     * Cette méthode permet juste d'afficher des sauts de ligne.
     * Elle permet simplement d'éviter de surcharger les affichages
     * d'interface avec énormement de \n
     * 
     * ENTREES
     * =======
     * @param nbr
     *          Le nombre de lignes à sauter
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void lignes(int nbr){
        for (int i = 0; i < nbr; i++) {
            System.out.println(" ");
        }
    }
    
    /**
     * METHODE TITRE
     * =============
     * Cette méthode permet d'afficher et de mettre en forme un titre dans
     * un interface
     * 
     * ENTREES
     * =======
     * @param titre
     *          Le titre à mettre en forme et à afficher
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void titre(String titre){
        for (int i = 0; i < 60-(titre.length()/2); i++) {
            System.out.printf(" ");
        }
        System.out.printf(titre.toUpperCase());
    }
    
    /**
     * METHODE IMPORTATION_ASCII
     * =========================
     * Cette méthode permet d'importer, à partir d'un fichier .asciiART
     * un dessin à afficher
     * 
     * ENTREES
     * =======
     * @param nomFichier
     *          Le nom du fichier .asciiART à importer
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void importationASCII(String nomFichier){
        // Essai d'ouverture du fichier
        try (BufferedReader in = new BufferedReader(new FileReader("./src/simulateurzytho/files/ascii/"+nomFichier+".asciiART"))) {
            String ligne;
            // Affichage ligne par ligne
            while((ligne = in.readLine()) != null)
            {
                System.out.println(ligne);
            }
        }
        catch(IOException e)
        {
            System.out.println(RED+"Impossible d'ouvrir le fichier './src/simulateurzytho/files/ascii/"+nomFichier+".asciiART'"+RESET);
        }  
    }
    
    /**
     * METHODE AFFICHAGE_INTERFACE
     * ===========================
     * Cette méthode permet d'afficher une interface, n'importe laquelle, 
     * simplement
     * 
     * ENTREES
     * =======
     * @param interfaceActuelle 
     *          Le nom de l'interface à afficher
     * @param statistiques
     *          Affichage ou non des statistiques du bar
     * @param asciiART
     *          Nom du fichier .asciiART à afficher, mettre null s'il ne faut rien afficher
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void affichageInterface(Interface interfaceActuelle, Integer[] statistiques){
        // Affichage du titre
        separation();
        titre(interfaceActuelle.getNom());
        lignes(1);
        separation();
        
        // Affichage des statistiques si besoin
        if(statistiques.length > 0){
            System.out.printf("Argent dépensé : " + GREEN + floatToString(statistiques[0], "000") + "€" + RESET + " - ");
            System.out.printf("Argent disponible : " + GREEN + floatToString(statistiques[1], "000") + "€" + RESET + " - ");
            System.out.printf("Nombre de clients : " + GREEN + statistiques[2] + RESET + " - ");
            System.out.printf("Nombre de serveurs : " + GREEN + statistiques[3] + RESET + " - ");
            System.out.printf("Stocks : " + GREEN + statistiques[4] + "%%" + RESET);
            
            lignes(2);
        }
        
        // Affichage d'une zone de dessin ASCII si demandé
        if(interfaceActuelle.getAsciiArt() != null){
            importationASCII(interfaceActuelle.getAsciiArt());
        }
        
        // Affichage de la navigation
        lignes(1);
        System.out.println(interfaceActuelle.displayEnfants());
        
        // Attente de l'instruction utilisateur
        separation();
        instructionUtilisateur(interfaceActuelle.getEnfants());
    }
    
    /**
     * METHODE FLOAT_TO_STRING
     * =======================
     * Cette méthode permet de passer d'un float à un string et d'imposer un 
     * format particulier
     * Par exemple avec le format "00.0" le float 2 sera écrit 02.0 et le
     * nombre 2.5 secra écrit 02.5.
     * 
     * ENTREES
     * =======
     * @param f
     *          Le nombre à traiter
     * @param format
     *          Le format souhaité sous forme "0.0"
     * 
     * SORTIES
     * =======
     * @return un string formaté sous la forme demandée
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static String floatToString(float f, String format){
        
        DecimalFormat formatter = new DecimalFormat(format);      

        return formatter.format(f);
        
    }
   
    public static void instructionUtilisateur(Interface[] enfants){
             
        // Demande à l'utilisateur une nouvelle interface
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
                      
        String raccourcis = input.nextLine();
        // Si le caractère entré est un chiffre, c'est une action de l'interface
        if(raccourcis != null && raccourcis.matches("[-+]?\\d*\\.?\\d+")){
            
        } else {
        // Si le caractère entré estu ne lettre, c'est une navigation
            Interface nextInterface = Interface.trouverInterface(enfants, raccourcis);
            
            Integer[] statistiques = {20, 2500, 52, 6, 20};
            clearScreen();
            AffichageGraphique.affichageInterface(
                    nextInterface,
                    statistiques);
        }
    }
    
}
