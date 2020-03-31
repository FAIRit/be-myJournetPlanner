package com.fairit.journeyapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name="app_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "user_login")
    @NotBlank(message = "Username is mandatory")
    private String username;
    @Column(name = "user_password")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Transient
    @NotBlank(message = "Password is mandatory")
    private String passwordConfirm;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_origin_country")
    private String originCountry;

    @ManyToMany
    @JoinTable
    private Set<Role> role;

    @OneToMany(mappedBy = "user")

    private List <Trip> tripsList;

}
