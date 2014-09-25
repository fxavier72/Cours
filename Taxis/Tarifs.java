package Taxis;

public class Tarifs {
	int dep;
	double priseCharge;
	double ARJS;
	double ASJS;
	double THJS;
	double TKARND;
	double TKASND;
	double THND;
	
	// Constructeur par défaut
	public Tarifs(){
		dep = 0;
		priseCharge = 0.0;
		ARJS = 0.0;
		ASJS = 0.0;
		THJS = 0.0;
		TKARND = 0.0;
		TKASND = 0.0;
		THND = 0.0;
	}
	
	// Constructeur avec paramètre
	public Tarifs(int dept, double pC, double arjs, double asjs, double thjs, double tkarnd, double tkasnd, double thnd){
		System.out.println("Selection du département !");
		dep = dept;
		priseCharge = pC;
		ARJS = arjs;
		ASJS = asjs;
		THJS = thjs;
		TKARND = tkarnd;
		TKASND = tkasnd;
		THND = thnd;
	}
		
}
