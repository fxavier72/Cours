package Taxis;

public class Tarifs {
	private int dep;
	private double priseCharge;
	private double ARJS;
	private double ASJS;
	private double THJS;
	private double TKARND;
	private double TKASND;
	private double THND;
	
	public int getDep(){
		return dep;
	}
	
	public double getPriseCharge(){
		return priseCharge;
	}
	
	public double getARJS(){
		return ARJS;
	}
	
	public double getASJS(){
		return ASJS;
	}
	
	public double getTHJS(){
		return THJS;
	}
	
	public double getTKARND(){
		return TKARND;
	}
	
	public double getTKASND(){
		return TKASND;
	}
	
	public double getTHND(){
		return THND;
	}
	
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
