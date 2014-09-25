package Taxis;
import java.util.Scanner;
import Taxis.Calculer;
import Taxis.Tarifs;
import Taxis.saisie; 

public class taxi {
	
	// Déclaration de objets
	static saisie saisir = new saisie();
	static Calculer calculer = new Calculer();
	static Tarifs tarifs = new Tarifs();
	
	// On déclare un tableau a une dimention pour chaque département
	static double[][] tarifDep = {
		{21, 2, 0.86, 1.72, 21.93, 1.29, 2.58, 21.93},
		{25, 2.1, 0.83, 1.66, 22.5, 1.2, 2.4, 22.5},
		{39, 2.1, 0.83, 1.66, 22.5, 1.23, 2.46, 25},
		{44, 2.2, 0.79, 1.58, 24.19, 1.19, 2.37, 24.19},
		{72, 2.15, 0.79, 1.58, 22.86, 1.19, 2.38, 22.86},
		{73, 2.4, 0.84, 1.68, 25.4, 1.26, 2.52, 25.4},
		{74, 3.15, 0.92, 1.84, 17.3, 1.38, 2.76, 17.3},
		{75, 2.5, 1, 1.24, 0, 1.5, 1.5, 0},
		{85, 2.3, 0.8, 1.6, 22.2, 1.2, 2.4, 22.2},
		{90, 2.2, 0.83, 1.66, 21, 1.15, 2.3, 21}
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Arrondi a deux chiffres apr�s la virgule
				java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
						
				//On initialise la variable prix � 0
				double prix = 0.0;
				
				saisir.Saisie();
				
				Calculer.Calcul(tarifDep);
				
				System.out.println("Le montant de la course est de : " +String.valueOf(df.format(prix))+ " €");
		



}
	
	// Déclaration de la fonction Calculer 
	
	
}

