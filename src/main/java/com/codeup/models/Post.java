package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by nedwaldie on 2/8/17.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 30)
    @NotBlank(message = "Ads must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    private String title;
    @Column(nullable = false, length = 500)
    @NotBlank(message = "Ads must have a body")
    @Size(min = 5, message = "A body must be at least 5 characters.")
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;





    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
