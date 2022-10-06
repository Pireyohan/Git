package gestion.de.profil;

import java.util.ArrayList;

public interface IPost {

    public boolean publicatePost(Post post);

    public Post getByPostId(int id);

    public ArrayList<Post> getAllPost();

    public boolean update(Post post);

    public boolean delete(int id);

}
