package gestion.de.profil;

import java.util.ArrayList;

public interface IFollow {

    // Fonction pour afficher ts les follow d'un user avec un autre
    public ArrayList<Follow> getAllPostFollow();

    // fonction....
    public boolean createFollowing(Follow follow);

    public boolean delete(Follow follow);

}
