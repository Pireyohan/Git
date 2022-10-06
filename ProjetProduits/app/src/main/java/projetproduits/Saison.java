package projetproduits;

public interface Saison {
    public EPeriode getSaison();
    public void setSaison(EPeriode saison);

    public int getRemise();
    public void setRemise(int remise);

    public int getPrix();
    public void setPrix(int prix);
}
