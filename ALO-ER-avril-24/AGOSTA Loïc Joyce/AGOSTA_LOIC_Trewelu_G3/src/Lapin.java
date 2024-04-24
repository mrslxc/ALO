/*********************/
// LOIC AGOSTA
//
/*********************/

import java.util.ArrayList;


public class Lapin {
	private String nom;
	private String typeChocolat ; // soit "au lait", soit "blanc", soit "noir", soit "matcha"
	private boolean garni; // false si le lapin ne contient rien et true s'il contient des bonbons ou des petits oeufs
	private Coord position;
	private double poids; //en kilo
	
	public Lapin(String nom, String typeChocolat, boolean garni, int x, int y,	double poids)
	{
		this.nom = nom;
		this.typeChocolat = typeChocolat;
		this.garni = garni;
		position = new Coord(x, y);
		this.poids = poids;
	}

	public String getNom() {
		return nom;
	}

	public String getTypeChocolat() {
		return typeChocolat;
	}

	public boolean isGarni() {
		return garni;
	}

	public Coord getPosition() {
		return position;
	}

	public double getPoids() {
		return poids;
	}

	//NE PAS MODIFIER la fonction distanceAvec!!
	public int distanceAvec(Lapin autreLapin)
	{
		return position.distanceAvec(autreLapin.position);
	}

	//NE PAS MODIFIER la fonction toString !!
	public String toString()
	{
		String indicationGarni = "";
		if ( garni )
			indicationGarni = " (garni)";
		return nom+" pèse "+Util.arrondir(1000*poids)+" grammes de chocolat "+typeChocolat+indicationGarni+
			   " et se trouve aux coordonnées "+position;
	}

	//afficherDistanceAvecLesAutres_Q4a A compléter, on veut ici afficher la distance d'un lapin par rapport à une liste de lapins passée en paramètres
	public void afficherDistanceAvecLesAutres_Q4a(ArrayList<Lapin> liste)
	{

	}
}

