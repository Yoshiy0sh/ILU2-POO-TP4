package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal <P extends IProduit>{
	private Gaulois vendeur;
	private P[] produits;
	private int nbProduit;
	private int prix;
	
	public void installerVendeur(Gaulois vendeur, P[] produits, int prix) {
		this.vendeur = vendeur;
		this.produits = produits;
		this.prix = prix;
	}
}
