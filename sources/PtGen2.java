/*********************************************************************************
 *   polyP7-exoExp : PtGen2 donne le code des traitements a effectuer            *
 *                   lors de l'analyse d'une expression                          *
 *   squelette de PtGen2 fourni aux étudiants, a compléter pour grammaire  Exp2  *
 *   nom de l'expression analysee, sans suffixe : String    nomSource            *
 *   ----------------------------                                                *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int PtGen2.valEnt = valeur du dernier nombre entier lu (item nbentier)    *
 *     int PtGen2.idLu = chaine du dernier identificateur lu (item ident)        *
 *                                                                               *
 *                          N. GIRARD - A. GRAZON - V.MASSON                     *
 *********************************************************************************/


import java.io.*;

public class PtGen2 {
    

    public static String trinome = "a completer";
    public static int valEnt;
    public static String idLu;

    // initialisations  a  completer 
    // -------------------------------------
 

    // code des points de generation à completer
    // -------------------------------------
    public static void pt(int numGen) {
    	switch (numGen) {  
    	case  0: break;
		// ... à compléter
    
    	
    	default : System.out.println("Point de generation non prevu dans votre liste");break;
    	
    	}
        }
}
 