package gestion.de.profil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class User {
    protected int id;

    protected String fullName = "";
    protected String pseudo = "";
    protected String password = "";
    protected String email = "";

    public User() {
        super();
    }

    public User(String fullName, String pseudo, String password, String email) {
        this.fullName = fullName;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean createUser(User user) {
        String sql = "";
        if (user.getId() == 0) {
            sql = "INSERT INTO user(pseudo, nomUser,email,password)"
                    + " values(?,?,?,?);";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, user.getPseudo());
                pstmt.setString(2, user.getFullName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getPassword());

                pstmt.executeUpdate();

                ResultSet keys = pstmt.getGeneratedKeys();
                if (user.getId() == 0 && keys.next()) {
                    user.setId(keys.getInt(1));
                    return true;
                } else if (user.getId() != 0)
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

    public User getById(int id) {
        User user = new User();
        try {
            ResultSet result = DBManager.execute("select * from user where idUser=" + id);
            if (result.next()) {
                user.setPseudo(result.getString("pseudo"));
                user.setFullName(result.getString("nomUser"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));

                return user;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());

        }

        return null;
    }

    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        try {
            ResultSet result = DBManager.execute("SELECT * FROM user");
            while (result.next()) {
                user.setPseudo(result.getString("pseudo"));
                user.setFullName(result.getString("nomUser"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setId(result.getInt("idUser"));
                users.add(user);
            }
            return users;
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
            System.out.println("VendoError: " + ((SQLException) ex).getErrorCode());
        }
        return users.size() == 0 ? null : users;
    }

    public boolean update(User user) {
        String sql = "";
        if (user.getId() != 0) {
            sql = "UPDATE user SET pseudo=?, nomUser=?,email=?, password=?"
                    + " WHERE idUser= ?;";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, user.getPseudo());
                pstmt.setString(2, user.getFullName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getPassword());

                pstmt.executeUpdate();

                ResultSet keys = pstmt.getGeneratedKeys();
                if (user.getId() == 0 && keys.next()) {
                    user.setId(keys.getInt(1));
                    return true;
                } else if (user.getId() != 0)
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
        User user = getById(id);
        if (user == null) {
            System.out.println("Impossible de supprimer le user avec l'id : " + id);
            return false;

        } else {

            int result = DBManager.executeUpdate("DELETE FROM user WHERE idUser=" + id + ";");
            return result != 0 ? true : false;
        }

    }

    public User getByIdWithPost(int id) {
        User user = new User();
        try {
            return user;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String toString() {
        return " User =>" + email + ", nom " + fullName + ", password=" + password + ", pseudo="
                + pseudo;
    }
}
