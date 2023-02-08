// Grammaire du langage Exp2, poly page 7
// N. GIRARD - A. GRAZON - V.MASSON
// grammaire fournie aux étudiants qui doivent y ajouter les appels à Ptgen.pt(k)

// Attention l'analyse est poursuivie après erreur si l'on supprime la clause rulecatch

grammar Exp2;

options {
  language=Java; 
  k=1;
 }

@header {           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
} 

// partie syntaxique :  description de la grammaire //


@members {
// variables globales et methodes utiles a placer ici
}
// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
@rulecatch {
catch (RecognitionException e) {reportError (e) ; throw e ; }}


unite  :    exp {System.out.println("fin analyse syntaxique");}  EOF
  ;
  
exp   : (terme) 
        ('+' terme  
        |'-' terme  
        )*
  ;
  
terme  : (primaire) 
        ( '*'  primaire  
        | 'div' primaire  
        )*
  ;
  
primaire: nbentier 
  | ident 
  | '(' exp ')'
  ;

// partie lexicale  //
// attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors necessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unite lexicale INT, le non-terminal nbentier a du etre introduit
       
nbentier  :   INT { PtGen2.valEnt = Integer.parseInt($INT.text);};
ident : ID  { PtGen2.idLu = $ID.text; } ; 
     
// zone purement lexicale //

INT :   '0'..'9'+ ;
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z')* ; 
WS  :   (' '|'\t' | '\n' |'\r')+ {skip();} ; // definition des "espaces"

	   