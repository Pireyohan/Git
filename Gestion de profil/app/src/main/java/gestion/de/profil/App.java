package gestion.de.profil;

public class App {
    /**
     * @author Pire Yohan
     * @implNote Application de gestion de profil
     * @implNote Utilisation de la base de donnée bdValidationYo
     * @param args
     */

    public static void main(String[] args) {
        DBManager.init();

        /* Partie CRUD User */
        // Je créer un user lambda et je l'affiche par la méthode create et getbyId
        User user = new User();
        user.setPseudo("Rara");
        // user.setPassword("allyour");
        user.setFullName("Rachid");
        user.setEmail("Rachid@hotmail.fr");
        user.setPassword("123465");
        user.createUser(user);

        // test la méthode getById de user mais pas mit en place pour l'IHM
        System.out.println(user.getById(2).toString());
        System.out.println("**************");

        // On peut afficher l'ensemble des profils par getAll sans IHM pour l'instant
        System.out.println(user.getAll().toString());

        // On peut delete le user par son Id , pas d'IHM via scanner now
        // user.delete(1);

        /* Partie CRUD POST */
        // ID dispo 2,3
        System.out.println("**************************");
        Post postFirst = new Post();
        postFirst.setDate("10/02/2022");
        postFirst.setTitle("La mouche qui pete");
        postFirst.setContent("C'est un texte sur les plantes");

        /* Affectation d'un post a un user via son ID */
        User user2 = new User();
        user2.setId(3);
        postFirst.setUser(user2);
        postFirst.publicatePost(postFirst);
        System.out.println("***************************");
        System.out.println(postFirst.getByPostId(2));

        /* Affichage de tous les posts */
        System.out.println(postFirst.getAllPosts());
        System.out.println("*************************************");

        /* Affichage de ts les post via une Id */
        System.out.println(postFirst.getAllPostByIdUser(3));

        /* Affichage d'un post Liker une fois le like ajouté */
        Post postLiker = new Post();
        User userLiker = new User();
        userLiker = user.getById(1);

        Like like = new Like();
        like.likerLePost(postLiker, userLiker);

        // IHM
    }
}
