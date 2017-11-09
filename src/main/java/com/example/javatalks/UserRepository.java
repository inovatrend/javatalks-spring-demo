package com.example.javatalks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    // ova metoda se ne koristi, tu je samo za primjer
    // query metoda, iz imena metode JPA zna generirati sql query
    // da bi to radilo naziv metode mora sljediti konveciju, pravila su na linku ispod
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
    List<User> findByFirstName(String matchName);



}
