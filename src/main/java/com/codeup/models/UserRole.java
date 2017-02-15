package com.codeup.models;

import javax.persistence.*;

/**
 * Created by nedwaldie on 2/13/17.
 */
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role")
    private String role;

}