package scenarioTest;

import produit.*;
import villagegaulois.*;
import personnages.*;

public class ScenarioTest {
	
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfab�tix",9);
		Gaulois obelix = new Gaulois("Ob�lix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		//cr�ation du march�
		
		IEtal[] marche = new IEtal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		
		Etal<Poisson> etalPoisson = new Etal<>();
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		//etal asterix
		marche[0] = etalSanglier1;
		//etal obelix
		marche[1] = etalSanglier2;
		//etal ordralfabetix	
		marche[2] = etalPoisson;
		
		//afficher le march�
		
		
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
		
		int nbSanglier = 0;
		for (int i = 0; i < marche.length && nbSanglier < 3; i++) {
			int quantiteDispo = marche[i].contientProduit("sanglier", 3);
			int quantiteSouhaitee = 3 - nbSanglier;
			
			int quantiteAchetee = Math.min(quantiteSouhaitee,quantiteDispo);
			
			int prix = marche[i].acheterProduit(quantiteAchetee);
			
			System.out.println("j'ach�te "+ quantiteAchetee  + " a l'etal " + (i+1) + " pour tant de sous : " +prix);
			nbSanglier += quantiteAchetee;
		}
		
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
		
		
	}
}
