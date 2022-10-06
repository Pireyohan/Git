package projetproduits;

public class ProduitFugace extends ProduitPerissable implements Saison {
    protected int remise = 0;
    protected Periode saison = Periode.aucune;

    public ProduitFugace(String code) {
        super(code);
    }

    @Override
    public Periode getSaison() {
        return saison;
    }

    @Override
    public void setSaison(Periode saison) {
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
    
}
