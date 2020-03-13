package com.fairit.journeyapp.accessdata;

import com.fairit.journeyapp.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findUserById(int id);

    AppUser findAppUserByLogin(String login);

    List<AppUser> findAll();
}
