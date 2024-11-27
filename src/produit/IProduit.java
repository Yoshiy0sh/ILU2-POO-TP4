package produit;

public interface IProduit {

	String getNom();

	String getUnite();

	String decrireProduit();
	
	int calculerPrix(int prix);

}