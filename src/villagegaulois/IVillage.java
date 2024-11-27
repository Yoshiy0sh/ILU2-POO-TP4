package villagegaulois;

import personnages.Gaulois;
import produit.*;

public interface IVillage {
	public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix);

	public void acheterProduit(String produit, int quantiteSouhaitee);
}
