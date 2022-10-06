package gestion.de.profil;

import java.util.List;

public interface ILike {
    /* Fonction qui permet de liker un post en fonction d'un user */
    public boolean likerLePost(Post post, User user);

    /* Fonctions qui permettent de donner les postes likés all et byID user */
    public List<Like> getAllPostLike();

    public List<Like> getAllPostLikeByIdUser(User User);

}
