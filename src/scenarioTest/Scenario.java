package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.*;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage(){
			
			private int nbVendeurs = 0;
			private static final int NB_VENDEUR_MAX = 3;
			private IEtal[] marche  = new IEtal[NB_VENDEUR_MAX];
			
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if(nbVendeurs != NB_VENDEUR_MAX) {
					Etal<P> newEtal = new Etal<>();
					newEtal.installerVendeur(vendeur, produit, prix);
					marche[nbVendeurs] = newEtal;
					nbVendeurs++;
					return true;
				}
				else return false;
			}
			
			
			@Override
			public void acheterProduit(String produit, int quantite) {
				int nbProduits = 0;
				for (int i = 0; i < marche.length && nbProduits < quantite; i++) {
					int quantiteDispo = marche[i].contientProduit(produit, quantite);
					int quantiteSouhaitee = quantite - nbProduits;
					
					int quantiteAchetee = Math.min(quantiteSouhaitee,quantiteDispo);
					
					int prix = marche[i].acheterProduit(quantiteAchetee);
					
					System.out.println("à l'étal "+ (i+1)  + " j'achète " + quantiteAchetee + " " + produit+  " pour " +prix + " sous");
					nbProduits += quantiteAchetee;
				}
				System.out.println("Je voulais " + quantite + " " + produit + ", j'en ai achetÃ© " + nbProduits +"\n");
			}
			
			public String toString() {
				StringBuilder chaine = new StringBuilder();
				for (int i = 0; i < marche.length; i++) {
					chaine.append(marche[i].etatEtal());
				}
				return chaine.toString();
			}
		};
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
