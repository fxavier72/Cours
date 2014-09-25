package Taxis;

public class Calculer {
		//D�claration des variables de saisie 	
		
		static int dep, kil, minutes;
		static char typeParcour;
		static String jour, heure;
		
		public static double Calcul(double[][] dept){
			
			double prix = 0.0;
			
			if(typeParcour == 'S'){ // Si le trajet et un aller simple
				if(jour.equals("Lundi")  || jour.equals("Mardi") || jour.equals("Mercredi") || jour.equals("Jeudi") || jour.equals("Vendredi") || jour.equals("Samedi")){ // et que le jour se trouve dans les valeurs donn�e 
					if (heure.equals("jour")){ // et que l'heure est = � jour
						if(minutes < 60){ // et que les minutes sont inf�rieur � 60
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
