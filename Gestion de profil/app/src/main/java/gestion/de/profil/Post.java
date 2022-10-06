package gestion.de.profil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Post {
    protected int id = 0;
    protected String date = "";
    protected String title = " ";
    protected String content = "";
    protected User user;

    public Post(int id, String date, String title, String content, User user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Post() {
        super();
    }

    public boolean publicatePost(Post post) {
        String sql = "";
        if (post.getId() == 0) {
            sql = "INSERT INTO post VALUES(0,?,?,?,?);";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, post.getDate());
                pstmt.setString(2, post.getTitle());
                pstmt.setString(3, post.getContent());
                pstmt.setInt(4, post.getUser().getId());
                // post.getUtilisateur.getID()

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

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        // DBManager.init();;
        try {
            ResultSet result = DBManager.execute("SELECT * FROM post");
            while (result.next()) {
                User user = new User();
                user = user.getById(result.getInt("user_iduser"));
                Post post = new Post();
                post.setId(result.getInt("idStatut"));
                post.setDate(result.getString("postDate"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                post.setUser(user);
                posts.add(post);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
            System.out.println("VendoError: " + ((SQLException) ex).getErrorCode());
        }
        return posts;
    }

    public Post getAllPostByIdUser(int id) {
        Post post = new Post();
        try {
            ResultSet result = DBManager.execute("select * from post where user_iduser =" + id);
            if (result.next()) {
                post.setDate(result.getString("postDate"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                return post;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

        }

        return null;
    }

    public Post getByPostId(int id) {
        Post post = new Post();
        try {
            ResultSet result = DBManager.execute("select * from post where idStatut=" + id);
            if (result.next()) {
                post.setDate(result.getString("postDate"));
                post.setTitle(result.getString("title"));
                post.setContent(result.getString("content"));
                return post;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

        }

        return null;
    }

    public boolean update(Post post) {
        String sql = "";
        if (post.getId() != 0) {
            sql = "UPDATE post " +
                    "SET postDate=?,title=?,content=? " +
                    "WHERE idStatut=?";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, post.getDate());
                pstmt.setString(2, post.getTitle());
                pstmt.setString(3, post.getContent());

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

    public boolean delete(int id) {
        Post post = getByPostId(id);
        if (post == null) {
            System.out.println("Impossible de supprimer le post avec l'id : " + id);
            return false;

        } else {

            int result = DBManager.executeUpdate("DELETE FROM post WHERE idStatut=" + id + ";");
            return result != 0 ? true : false;
        }

    }
    // #region getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // #endregion

    @Override
    public String toString() {
        return "Post [content=" + content + ", date=" + date + ", title=" + title + ", user=" + this.user
                + "]";
    }
}
