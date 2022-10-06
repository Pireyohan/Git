package M2ijpahibernate.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FilmActorPK implements Serializable {

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "actor_id")
    private Integer actorId;

    public FilmActorPK() {
    }

    public FilmActorPK(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actorId == null) ? 0 : actorId.hashCode());
        result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FilmActorPK other = (FilmActorPK) obj;
        if (actorId == null) {
            if (other.actorId != null)
                return false;
        } else if (!actorId.equals(other.actorId))
            return false;
        if (filmId == null) {
            if (other.filmId != null)
                return false;
        } else if (!filmId.equals(other.filmId))
            return false;
        return true;
    }

}
