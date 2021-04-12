/************
@author : -
Programme : Test Loup / Chou / Mouton 
***********/

import java.util.Scanner; 

 public class TestBCLM
{
   public static void main(String[] arg)
   {
        /****************************/
	    /*~~DECLARATION DE L'OBJET~~*/
	    /****************************/
        BergerChouLoupMouton berger, loup, mouton, chou;

        /*************************/
	    /*~~VARIABLE DE L'OBJET~~*/
	    /*************************/
   		char nord='N';
   		char sud='S';

        String especeBerger="BERGER";
        String especeChou="CHOU";
   		String especeLoup="LOUP";
   		String especeMouton="MOUTON";
   		
   		char choix;

        boolean partie=false;
        boolean gagne = false;
           
        Scanner sc = new Scanner(System.in);

        /******************************/
	    /*~~INSTANCIATION DES OBJETS~~*/
	    /******************************/
   		//Depart LOUP ET CHOU au NORD
   		berger = new BergerChouLoupMouton(nord, "BERGER");
   		loup = new BergerChouLoupMouton(nord, "LOUP");
   		mouton = new BergerChouLoupMouton(nord, "MOUTON");
   		chou = new BergerChouLoupMouton(nord, "CHOU"); 


    // Etape de la traversée
	do
	{
		
		System.out.print("Choisissez un animal a faire traverser : [L/M/C] ");
		choix = sc.next().charAt(0);

        // l'animal a deplacé 
        TestBCLM.choix(choix, berger, loup, mouton, chou);
		
        
        
        // le loup
        if ( loup.getPosition() == mouton.getPosition() && berger.getPosition() != loup.getPosition()) {System.out.println("Test 1"); partie = true;} // loup
        
        
        
        // chou et le mouton
        if(chou.getPosition() == mouton.getPosition() && berger.getPosition() != chou.getPosition()) {System.out.println("Test 2"); partie = true;}
        
       
       
        // test vainqueur
        if (chou.getPosition() == 'S' && loup.getPosition() == 'S' && mouton.getPosition() == 'S' ) {System.out.println("GG");gagne = true;}

        System.out.print(TestBCLM.affichage(berger, loup, mouton, chou));

    }while(!partie && !gagne);
    
    System.out.print(TestBCLM.affichage(berger, loup, mouton, chou));

    // resultat
    String resultat = TestBCLM.resultat(gagne, berger, loup, mouton, chou);
    System.out.println(resultat);

   }


    private static void choix (char choix_joueur, BergerChouLoupMouton berger, BergerChouLoupMouton loup, BergerChouLoupMouton mouton, BergerChouLoupMouton chou )
    {
        // si le choix du joueur se trouve sur l'autre rive alors on deplace le berger 
        switch (choix_joueur) 
		{
            case 'M':
            case 'm': 
            if (mouton.getPosition() != berger.getPosition()){berger.setPosition(); } // doit etre sur la meme rive pour transporter
            //System.out.println ("VOUS AVEZ DEPLACER LE MOUTON");
            mouton.setPosition();
            
           
            System.out.print("Position M : " + mouton.getPosition() + "\n");
            break;

            case 'L' : 
            case 'l':
            if (loup.getPosition() != berger.getPosition()){berger.setPosition(); }

			
			
            loup.setPosition();

            System.out.print("Position L : " + loup.getPosition() + "\n" );
            
            break;
            
            case 'C' :
            case 'c':
            if (chou.getPosition() != berger.getPosition()){berger.setPosition(); }
           
            chou.setPosition();
            
            System.out.print("Position C : " + chou.getPosition() + "\n" );
            break;
            

        }
        berger.setPosition(); // le berger se déplace simultanément
        
    }

    private static String resultat(boolean gagne, BergerChouLoupMouton berger, BergerChouLoupMouton loup, BergerChouLoupMouton mouton, BergerChouLoupMouton chou)
    {
        String chaine="Vous avez perdu";

        if (gagne)
        {
            chaine = "Vous avez gagne, tous les personnages ont atteins la rive sud!" + "\n";
            chaine += "Pos Berger : " +  berger.getPosition() + " (Sud) ";
            chaine += "Pos Chou : " +  chou.getPosition() + " (Sud) ";
            chaine += "Pos Loup : " +  loup.getPosition() + " (Sud) ";
            chaine += "Pos Mouton : " +  mouton.getPosition() + " (Sud) ";
        }

        return chaine;
    }

    private static String affichage(BergerChouLoupMouton berger, BergerChouLoupMouton loup, BergerChouLoupMouton mouton, BergerChouLoupMouton chou)
    {
        String sLigneHori;
        String sRet;

        String rN = "Rive Nord";
        String rS = "Rive Sud";
        
        String chouNord="Chou", loupNord="Loup", moutonNord="Mouton";
        String chouSud="Chou", loupSud="Loup", moutonSud="Mouton";
        
        /*---------------------TEST D'AFFICHAGE-------------------*/
        // chou
        if(chou.getPosition() == 'N'){chouSud = "";} else{chouNord="";} 
        //loup
        if(loup.getPosition() == 'N'){loupSud = "";} else{loupNord="";} 
        //mouton
        if(mouton.getPosition() == 'N'){moutonSud = "";} else {moutonNord="";} 

        /*---------------------HAUT D'AFFICHAGE-------------------*/

        // construction de la ligne horizontale
		sRet = "+";
		for( int cpt=0; cpt< 9; cpt++ ){sRet += "--+";}

        // construction des cases
		sRet = sRet + "\n";
               // +--+--+--+--+--+--+--+--+--+
        sRet += "|";
        sRet += String.format ( "%19s",  rN)+  "       |"+ "\n";

        sRet += "+";
		for( int cpt=0; cpt< 9; cpt++ ){sRet += "--+";}
        sRet = sRet + "\n"; 

        sRet += "   " + chouNord + " " + loupNord  + " " + moutonNord  +"\n";
        
        /*---------------------CENTER------------------------------*/
        
        for (int cpt=0; cpt<6; cpt++){sRet += "|                          |" + "\n"; }
        
        /*---------------BAS DE D'AFFICHAGE------------------------*/
        sRet += "   " + chouSud + " " + loupSud  + " " + moutonSud  +"\n";
        sRet += "+";
        for( int cpt=0; cpt< 9; cpt++ ){sRet += "--+";}

        sRet = sRet + "\n";
               // +--+--+--+--+--+--+--+--+--+
        sRet += "|";
        sRet += String.format ( "%19s",  rS)+  "       |"+ "\n";

        sRet += "+";
		for( int cpt=0; cpt< 9; cpt++ ){sRet += "--+";}
        sRet = sRet + "\n"; 
        

        return sRet;
    }


}



 

