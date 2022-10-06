package gestion.de.profil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Like {
    protected User user;
    protected Post post;
    protected int idUser = 0;
    protected int idPost = 0;

    public Like(int idUser, int idPost) {
        this.idUser = idUser;
        this.idPost = idPost;
    }

    public Like() {
        super();
    }

    public boolean likerLePost(Post post, User user) {
        String sql = "";

        if (post.getId() == 0 && user.getId() == 0) {
            sql = "INSERT INTO liker(post_idStatut,user_iduser)"
                    + " VALUES(?,?);";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, post.getId());
                pstmt.setInt(2, user.getId());

                pstmt.executeUpdate();

                ResultSet keys = pstmt.getGeneratedKeys();
                if (post.getId() == 0 && keys.next()) {
                    post.setId(keys.getInt(1));
                    return true;
                } else if (post.getId() != 0)
                    return true;
                else
                    return false;

            } catch (SQLException ex) {
                System.out.println("SQLException:" + ex.getMessage());
                System.out.println("SQLState:" + ex.getSQLState());
                System.out.println("VendorError:" + ex.getErrorCode());
                return false;
            }
        } else
            return false;

    }

    public List<Like> getAllPostLikeByIDUser(User User) {
        List<Like> likes = new ArrayList<>();
        User user = new User();
        try {
            ResultSet result = DBManager.execute("select * from post where user_iduser =" + user.getId() + ";");
            while (result.next()) {
                Like like = new Like();
                Post post = new Post();
                User user2 = new User();
                post = post.getByPostId(result.getInt("idStatut"));
                user2 = user.getById(user.getId());
                like.setPost(post);
                like.setUser(user2);
                likes.add(like);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

        }

        return likes;
    }

    // #region getter setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
    // #endregion

}
