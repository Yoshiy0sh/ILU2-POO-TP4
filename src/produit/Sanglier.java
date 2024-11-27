package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	
	private int poids;
	private	Gaulois chasseur;
	
	public Sanglier(int poids,Gaulois chasseur) {
		super("sanglier","kg");
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de " + poids + getUnite() + " chasse par " + chasseur.getNom();
	}
	
	@Override
	public int calculerPrix(int prix) {
		//ici la norme est 1250g = 1 sanglier
		return (poids*prix)/1000;
	}

}
