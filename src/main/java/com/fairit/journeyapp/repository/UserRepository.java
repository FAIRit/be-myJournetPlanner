package com.fairit.journeyapp.repository;

import com.fairit.journeyapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    void deleteById(long userId);

    User findUserById(Long userId);

    User findUserByUsername(String username);

    List<User> findAll();

    boolean existsByUsername(String username);

    User save(User user);

}
