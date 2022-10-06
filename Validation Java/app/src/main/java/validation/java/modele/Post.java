package validation.java.modele;

import java.util.Date;

public class Post {
    protected int id = 0;

    protected String title = " ";
    protected String content = "";
    protected Date date;

    public Post() {
        super();
    }

    public Post(int id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

}
