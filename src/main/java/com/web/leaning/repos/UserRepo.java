package com.web.leaning.repos;

import com.web.leaning.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByUsernameAndPassword(String username, String password);
}
