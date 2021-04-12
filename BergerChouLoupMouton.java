 /************
@author : -
Programme : Loup / Chou / Mouton 
***********/

public class BergerChouLoupMouton
{
	/**********************************/
	/*~~DONNEES/ATTRIBUTS DE L'OBJET~~*/
	/**********************************/
	private char dir;
    private String espece;
    

	/*********************/
   	/*~~CONSTRUCTEUR(S)~~*/
   	/*********************/  
	public BergerChouLoupMouton(char dir, String espece) // Constructeur de l'objet chou loup mouton berger
   	{
   		this.dir = dir;
   		this.espece = espece;
    }

   	/*******************/
   	/*~~ACCESSEUR(S)~~**/
   	/*******************/ 
	public char getPosition(){return this.dir;}
    public String getEspece(String espece) {return this.espece;}

  
    /**********************/
   	/*~~MODIFICATEUR(S)~~**/
   	/**********************/ 
   	public char setPosition() 
   	{
   		if( this.dir == 'N' ){this.dir='S';}
        else{this.dir='N';}
           
   		return this.dir;	
   	}

    /****************/
   	/*~~AFFICHAGE~~**/
    /****************/
    
    public String afficheObjet() 
    {
           String s="";
   
           s += " " + this.dir + " " + this.espece + "\n"; 
           return s;
    }
   
    public String toString() 
    {
        String s="";
   
        s += this.dir + "\n";  
        return s;
    }
       
}

