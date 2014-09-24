package Taxis;
import java.util.Scanner;

public class taxi {
	//Déclariation de variable globale
	
	//Déclaration des variables de saisie 
	static Scanner Saisie = new Scanner(System.in);
	static int dep, kil, minutes;
	static char typeParcour;
	static String jour, heure;
	
	// On déclare un tableau a une dimention pour chaque département
	static double[] dep21 = {2, 0.86, 1.72, 21.93, 1.29, 2.58, 21.93};
	static double[] dep25 = {2.1, 0.83, 1.66, 22.5, 1.2, 2.4, 22.5};
	static double[] dep39 = {2.1, 0.83, 1.66, 22.5, 1.23, 2.46, 25};
	static double[] dep44 = {2.2, 0.79, 1.58, 24.19, 1.19, 2.37, 24.19};
	static double[] dep72 = {2.15, 0.79, 1.58, 22.86, 1.19, 2.38, 22.86};
	static double[] dep73 = {2.4, 0.84, 1.68, 25.4, 1.26, 2.52, 25.4};
	static double[] dep74 = {3.15, 0.92, 1.84, 17.3, 1.38, 2.76, 17.3};
	static double[] dep75 = {2.5, 1, 1.24, 0, 1.5, 1.5, 0};
	static double[] dep85 = {2.3, 0.8, 1.6, 22.2, 1.2, 2.4, 22.2};
	static double[] dep90 = {2.2, 0.83, 1.66, 21, 1.15, 2.3, 21};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Arrondi a deux chiffres après la virgule
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
		
		//On initialise la variable prix à 0
		double prix = 0.0;
		
		//Saisie des informations demandé
		System.out.print("Veuillez saisir le dÃ©partement : ");
		dep = Saisie.nextInt();

		System.out.println("Veuillez saisir le nombre de kilomÃ¨tre : ");
		kil = Saisie.nextInt();

		System.out.println("Veuillez saisir s'il s'agit d'un aller simple (S) ou un Aller - Retour (R) : ");
		typeParcour = Saisie.next().charAt(0);

		System.out.print("Veuillez saisir le jour : ");
		jour = Saisie.next();

		System.out.print("Veuillez saisir la durÃ©e (en minutes) : ");
		minutes = Saisie.nextInt();

		System.out.print("Veuillez saisir l'heure (jour ou nuit) : ");
		heure = Saisie.next();
		
		// Calcul en fonction du département (Appel à la fonction Calculer pour faire le calcul)
		switch(dep){
			case 21: prix = Calculer(dep21);
				break; 
			case 25: prix = Calculer(dep25);
				break;
			case 39: prix = Calculer(dep39);
				break;
			case 44: prix = Calculer(dep44);
				break;
			case 72: prix = Calculer(dep72);
				break;
			case 73: prix = Calculer(dep73);
				break;
			case 74: prix = Calculer(dep74);
				break;
			case 75: prix = Calculer(dep75);
				break;
			case 85: prix = Calculer(dep85);
				break;
			case 90: prix = Calculer(dep90);
				break;
				

	}
		// On affiche le résultat
		System.out.println("Le montant de la course est de : " +String.valueOf(df.format(prix))+ " â‚¬");



}
	
	// Déclaration de la fonction Calculer 
	public static double Calculer(double[] dept){
		
		double prix = 0.0;
		
		if(typeParcour == 'S'){ // Si le trajet et un aller simple
			if(jour.equals("Lundi")  || jour.equals("Mardi") || jour.equals("Mercredi") || jour.equals("Jeudi") || jour.equals("Vendredi") || jour.equals("Samedi")){ // et que le jour se trouve dans les valeurs donnée 
				if (heure.equals("jour")){ // et que l'heure est = à jour
					if(minutes < 60){ // et que les minutes sont inférieur à 60
						prix = dept[0] + (kil * dept[2]);
					}
					else{
						prix = dept[0] + (kil * dept[2]) + ((int)(minutes/60) * dept[3]);
					}
				}
				else if(jour.equals("Dimanche")){
						if(heure.equals("jour")){
							if(minutes < 60){
								prix = dept[0] + (kil * dept[5]);
							}
							else{
								prix = dept[0] + (kil * dept[5]) + ((int)(minutes/60) * dept[6]);
							}
						}
				}
				else if (jour.equals("Lundi")  || jour.equals("Mardi") || jour.equals("Mercredi") || jour.equals("Jeudi") || jour.equals("Vendredi") || jour.equals("Samedi") || jour.equals("Dimanche")){
					if (heure.equals("nuit")){
						if(minutes < 60){
							prix = dept[0] + (kil * dept[5]);
						}
						else{
							prix = dept[0] + (kil * dept[5]) + ((int)(minutes/60) * dept[6]);
						}
					}
				}

			}
		}
		else{
			if(typeParcour == 'R'){
				if(jour.equals("Lundi")  || jour.equals("Mardi") || jour.equals("Mercredi") || jour.equals("Jeudi") || jour.equals("Vendredi") || jour.equals("Samedi")){
					if (heure.equals("jour")){
						if(minutes < 60){
							prix = dept[0] + (kil * dept[1]);
						}
						else{
							prix = dept[0] + (dept[3] + (kil * dept[1]));
						}
					}
					else if(jour.equals("Dimanche")){
							if(heure.equals("jour")){
								if(minutes < 60){
									prix = dept[0] + (kil * dept[4]) + ((int)(minutes/60) * dept[6]);
								}
								else{
									prix = dept[0] + (kil * dept[4]) + ((int)(minutes/60) * dept[6]);
								}
							}
					}
					else if (jour.equals("Lundi")  || jour.equals("Mardi") || jour.equals("Mercredi") || jour.equals("Jeudi") || jour.equals("Vendredi") || jour.equals("Samedi") || jour.equals("Dimanche")){
						if (heure.equals("nuit")){
							if(minutes < 60){
								prix = dept[0] + (kil * dept[4]);
							}
							else{
								prix = dept[0] + (kil * dept[4]) + ((int)(minutes/60) * dept[6]);
							}
						}
					}

				}
			}
		}
		
		return prix;
	}
	
}