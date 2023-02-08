// polyP7-exoExp : analyse syntaxique d'expressions 
// + traitement des expressions dirige par la syntaxe (affichages)
// 
// N. GIRARD - A. GRAZON - V.MASSON
// programme fourni aux �tudiants qui ne doivent pas le modifier
// ce programme contient le main qui demande le nom du texte source que l'on souhaite analyser, 
// et lance son analyse (appel�e compilation) a partir de l'axiome "unite" de la grammaire Exp2.g
// Il est prevu de pouvoir analyser plusieurs textes source de suite (arret par un retour-chariot)


import java.io.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

class Exp2 {
	public static String nomSource; // nom du source a compiler 
	
	private static void UneCompilation (String nomDuSource ) {
		try {
			ANTLRFileStream input = new ANTLRFileStream(nomDuSource);
			Exp2Lexer lexer = new Exp2Lexer(input);
			CommonTokenStream token_stream = new CommonTokenStream(lexer); // production d'un flot d'unites lexicales
			Exp2Parser parser = new Exp2Parser(token_stream);   
			PtGen2.pt(0); // point de generation des initialisations
			parser.unite(); // Compile le texte source en entree, l'axiome "unite" est precise

		 } catch (FileNotFoundException fnf) {
			System.out.println("exception: " + fnf); // cas ou le fichier source pr�cise n'existe pas
		}
		catch (RecognitionException re) {
	 	    System.out.println("Recognition exception: " + re); // erreur de nature syntaxique detectee par le lexer ou le parser
			// System.err.println dirige ses impressions sur une autre sortie et les messages ont alors tendance � se superposer
		}
		catch (IOException exc) {
			System.err.println("IO exception: " + exc);
		} 	
	} // UneCompilation
	
	
	public static void main(String [] args) {
		System.out.println("Premier exercice du poly : " + PtGen2.trinome);
		System.out.println("----------------------------------------");
		System.out.println();
		
		do 
		 {
			// lecture du nom de fichier en entree
			System.out.println(); 
		    System.out.print("Donnez le nom du fichier que vous souhaitez compiler :  (RC si termin�) ");
		    nomSource=Lecture.lireString();  
		    System.out.println();
		    
		    if (!nomSource.equals("")) {
		    	UneCompilation (nomSource); // traitement d'une compilation	
		    } 
		    System.out.println();
		 }
		while (!nomSource.equals("")); 	
		System.out.println("\n \n Merci pour votre patience, " + PtGen2.trinome + ", et � bient�t !!!");	
	} 
} 