package Taxis;

import java.util.Scanner;

public class saisie {
	
	static Scanner Saisie = new Scanner(System.in);
	
	private int dep, kil, minutes;
	private char typeParcour;
	private String jour, heure;
	
	public int getDep(){
		return dep;
	}
	
	public int getKil(){
		return kil;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public char getTypeParcour(){
		return typeParcour;
	}
	
	public String getJour(){
		return jour;
	}
	
	public String getHeure(){
		return heure;
	}
	
	public void Saisie(){
	//Saisie des informations demand�
	System.out.println("Veuillez saisir le département : ");
	dep = Saisie.nextInt();
	System.out.println("Veuillez saisir le nombre de kilomètre : ");
	kil = Saisie.nextInt();

	System.out.println("Veuillez saisir s'il s'agit d'un aller simple (S) ou un Aller - Retour (R) : ");
	typeParcour = Saisie.next().charAt(0);

	System.out.print("Veuillez saisir le jour : ");
	jour = Saisie.next();

	System.out.print("Veuillez saisir la durée (en minutes) : ");
	minutes = Saisie.nextInt();

	System.out.print("Veuillez saisir l'heure (jour ou nuit) : ");
	heure = Saisie.next();
	
	}

}
