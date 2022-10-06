package projetproduits;

public class Produit{
    protected String code = "";
    protected Denomination denomination;
    protected int prix = 0;

    public Produit(String code){
        this.code = code;
        this.denomination = new Denomination();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
}
