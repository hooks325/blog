package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by nedwaldie on 2/13/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "Enter a username")
    private String username;
    @Column(nullable = false)
    @NotBlank(message = "Enter a password")
    @Size(min = 3, message = "Your password should have a minimun of 8 characters")
    @JsonIgnore
    private String password;
    @Column(nullable = false)
    @Email
    @NotBlank(message = "Please enter an email address")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Post> posts;

    public User(User user) {
        id = user.id;
        username = user.username;
        password = user.password;
        email = user.email;
    }

    public User(){}

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}