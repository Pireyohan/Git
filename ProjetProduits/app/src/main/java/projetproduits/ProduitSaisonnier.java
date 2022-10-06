package projetproduits;

public class ProduitSaisonnier extends Produit implements Saison {
    protected EPeriode saison = EPeriode.aucune;
    protected int remise = 0;
    
    public ProduitSaisonnier(String code) {
        super(code);
    }

    @Override
    public EPeriode getSaison() {
        return saison;
    }
    
    @Override
    public void setSaison(EPeriode saison) {
        this.saison = saison;
    }

    @Override
    public int getRemise() {
        return remise;
    }
    @Override
    public void setRemise(int remise) {
        this.remise = remise;
    }

    @Override
    public int getPrix(){
        return super.getPrix() - this.remise;
    }
}
