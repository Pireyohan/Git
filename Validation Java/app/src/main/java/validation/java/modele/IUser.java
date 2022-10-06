package validation.java.modele;

import java.util.ArrayList;

public interface IUser {
    public boolean createUser(User user);

    public User getById(int id);

    public ArrayList<User> getAll();

    public User getByIdWithPost(int id);

    public boolean update(User user);

    public boolean delete(int id);

}
