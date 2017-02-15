package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nedwaldie on 2/13/17.
 */
@Repository
public interface Users extends CrudRepository<User, Long>{
    public User findByUsername(String username);
}
