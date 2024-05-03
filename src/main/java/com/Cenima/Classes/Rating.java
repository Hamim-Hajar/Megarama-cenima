//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Cenima.Classes;


import javax.persistence.*;

@Entity
@Table(
        name = "Rating"
)
public class Rating {
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @ManyToOne
    @JoinColumn(
            name = "film_id",
            nullable = false
    )
    private Film film;
    @Column(
            nullable = false
    )
    private int score;
    @Id
    private Long rat_id;

    public Rating() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRat_id(Long ratId) {
        this.rat_id = ratId;
    }

    public Long getRat_id() {
        return rat_id;
    }
}
