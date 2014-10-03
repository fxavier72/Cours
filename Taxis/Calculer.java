package Taxis;

import java.util.ArrayList;
import java.util.List;

public class Calculer {
		//Déclaration des variables de saisie 	
		
		static saisie saisir = new saisie();
		
		public static int Rechercher(saisie saisir){
			Boolean trouve = false;
			int i = 0;
			while (!trouve && i<taxi.mesTarifs.size()){
				if (taxi.mesTarifs.get(i).getDep() == saisir.getDep()){
					trouve=true;
				}
				else{
					i++;
				}
			}
			if (trouve == false)
				System.out.print("Le département saisie est incorrect");
			return i;
		}
		
		public static double Calcul(int i, saisie saisir){
			
			double prix = 0.0;
			
			if(saisir.getTypeParcour() == 'S'){ // Si le trajet et un aller simple
				if(saisir.getJour().equals("Lundi")  || saisir.getJour().equals("Mardi") || saisir.getJour().equals("Mercredi") || saisir.getJour().equals("Jeudi") || saisir.getJour().equals("Vendredi") || saisir.getJour().equals("Samedi")){ // et que le jour se trouve dans les valeurs donn�e 
					if (saisir.getHeure().equals("jour")){ // et que l'heure est = � jour
						if(saisir.getMinutes() < 60){ // et que les minutes sont inf�rieur � 60
							//Calcul OK
							prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getASJS());
						}
						else{
							System.out.println("Prise en charge : " + taxi.mesTarifs.get(i).getPriseCharge());
							System.out.println("GetKil : " + saisir.getKil());
							System.out.print("ARJS : " + taxi.mesTarifs.get(i).getARJS() + "\n");
							prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getARJS()) + (((saisir.getMinutes() - ((saisir.getMinutes() % 60))/60) * taxi.mesTarifs.get(i).getASJS()));
						}
					}
					else if(saisir.getJour().equals("Dimanche")){
							if(saisir.getHeure().equals("jour")){
								if(saisir.getMinutes() < 60){
									prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKASND());
								}
								else{
									prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKASND()) + (((saisir.getMinutes() - ((saisir.getMinutes() % 60))/60) * taxi.mesTarifs.get(i).getTHND()));
								}
							}
					}
					else if (saisir.getJour().equals("Lundi")  || saisir.getJour().equals("Mardi") || saisir.getJour().equals("Mercredi") || saisir.getJour().equals("Jeudi") || saisir.getJour().equals("Vendredi") || saisir.getJour().equals("Samedi") || saisir.getJour().equals("Dimanche")){
						if (saisir.getHeure().equals("nuit")){
							if(saisir.getMinutes() < 60){
								prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKASND());
							}
							else{
								prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKASND()) + ((int)(saisir.getMinutes()/60) * taxi.mesTarifs.get(i).getTHND());
							}
						}
					}
				}
			}
			else{
				if(saisir.getTypeParcour() == 'R'){
					if(saisir.getJour().equals("Lundi")  || saisir.getJour().equals("Mardi") || saisir.getJour().equals("Mercredi") || saisir.getJour().equals("Jeudi") || saisir.getJour().equals("Vendredi") || saisir.getJour().equals("Samedi")){
						if (saisir.getHeure().equals("jour")){
							if(saisir.getMinutes() < 60){
								prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getARJS());
							}
							else{
								prix = taxi.mesTarifs.get(i).getPriseCharge() + (taxi.mesTarifs.get(i).getTHJS() + (saisir.getKil() * taxi.mesTarifs.get(i).getARJS()));
							}
						}
						else if(saisir.getJour().equals("Dimanche")){
								if(saisir.getHeure().equals("jour")){
									if(saisir.getMinutes() < 60){
										prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKARND()) + ((int)(saisir.getMinutes()/60) * taxi.mesTarifs.get(i).getTHND());
									}
									else{
										prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKARND()) + ((int)(saisir.getMinutes()/60) * taxi.mesTarifs.get(i).getTHND());
									}
								}
						}
						else if (saisir.getJour().equals("Lundi")  || saisir.getJour().equals("Mardi") || saisir.getJour().equals("Mercredi") || saisir.getJour().equals("Jeudi") || saisir.getJour().equals("Vendredi") || saisir.getJour().equals("Samedi") || saisir.getJour().equals("Dimanche")){
							if (saisir.getHeure().equals("nuit")){
								if(saisir.getMinutes() < 60){
									prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKARND());
								}
								else{
									prix = taxi.mesTarifs.get(i).getPriseCharge() + (saisir.getKil() * taxi.mesTarifs.get(i).getTKARND()) + ((int)(saisir.getMinutes()/60) * taxi.mesTarifs.get(i).getTHND());
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
