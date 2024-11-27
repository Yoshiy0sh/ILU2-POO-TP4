package produit;

public class Poisson extends Produit {
	String date;
	
	public Poisson(String date) {
		super("Poisson", "piece");
		this.date = date;
	}
	
	@Override
	public String decrireProduit() {
		return "poisson peches " + date;
	}
	
	@Override
	public int calculerPrix(int prix) {
		//la norme ici est 1 poisson = prix
		return prix;
	}
}
