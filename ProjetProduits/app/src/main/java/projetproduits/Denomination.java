package projetproduits;

public class Denomination {
    protected String libelleLong = "";
    protected String libelleCourt = "";

    public Denomination(){

    }

    public String getLibelleLong() {
        return libelleLong;
    }

    public void setLibelleLong(String libelleLong) {
        this.libelleLong = libelleLong;
    }

    public String getLibelleCourt() {
        return libelleCourt;
    }

    public void setLibelleCourt(String libelleCourt) {
        this.libelleCourt = libelleCourt;
    }

    public void modifLibelle(String libelleCourt, String libelleLong){
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
    }

    public String afficheLiebelle(){
        return this.libelleCourt +" "+libelleLong;
    }
    
}
