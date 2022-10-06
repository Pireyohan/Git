package M2ijpahibernate.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    public Category() {

    }

    public Category(String name) {
        this.name = name;
        this.lastUpdate = new Date();
    }

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private Date lastUpdate;

    // @ManyToMany(mappedBy = "category")
    // private Set<Film> films;

    @OneToMany(mappedBy = "category")
    private Set<FilmCategory> fCategories = new HashSet<FilmCategory>();

    public Set<FilmCategory> getFCategory() {
        return fCategories;
    }

    public void addFCategory(FilmCategory fc) {
        fCategories.add(fc);
    }

    // #region get/set
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // public Set<Film> getFilms() {
    // return films;
    // }

    // public void setFilms(Set<Film> films) {
    // this.films = films;
    // }
    // #endregion

}
