package doju.dojuBackendGradle.business.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "highscores")
public class Highscore {
    @Id
    @Column(name = "id", updatable = false)
    private int id;

    @Column
    private Integer value;

    private Highscore(){
        super();
    }

    public Highscore(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Highscore{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
