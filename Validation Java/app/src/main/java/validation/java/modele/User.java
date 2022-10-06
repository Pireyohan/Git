package validation.java.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            sql = "INSERT INTO user(pseudo, fullname,email)"
                    + " values(?,?,?);";
            try {
                PreparedStatement pstmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, user.getPseudo());
                pstmt.setString(2, user.getFullName());
                pstmt.setString(3, user.getEmail());

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

}
