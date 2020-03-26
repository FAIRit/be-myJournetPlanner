package com.fairit.journeyapp.repository;

import com.fairit.journeyapp.model.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    void deleteByUsername(String username);

    User findUserById(Long userId);

    User findUserByUsername(String username);

    List<User> findAll();

    boolean existsByUsername(String username);
    User save(User user);

}
