package projetproduits;

import java.time.LocalDate;
import java.util.List;

public class ProduitPerissable extends Produit {
    protected int duree;
    protected LocalDate dateFab;

    public ProduitPerissable(String code) {
        super(code);
        dateFab =  LocalDate.now();
    }

    public ProduitPerissable(String code, String date){
        super(code);
        dateFab = LocalDate.parse(date);
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public LocalDate getDateFab() {
        return dateFab;
    }

    public void setDateFab(LocalDate dateFab) {
        this.dateFab = dateFab;
    }
    
}
