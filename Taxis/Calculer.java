package test;

import java.util.Scanner;

public class Calculer {
		//Déclaration des variables de saisie 
		static Scanner Saisie = new Scanner(System.in);
	
		static int dep, kil, minutes;
		static char typeParcour;
		static String jour, heure;
		
		//Arrondi a deux chiffres après la virgule
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
				
		//On initialise la variable prix à 0
		double prix = 0.0;
		
		//Saisie des informations demandé
				System.out.println("Veuillez saisir le département : ");
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
				
		System.out.println("Le montant de la course est de : " +String.valueOf(df.format(prix))+ " â‚¬");
		
		public static double Calcul(double[] dept){
			
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
			
			// On staock le prix dans une variable
			return prix;
		}
}
