package com.example.javatalks;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class UserSpecifications {

    public static Specification getByFirstName(String matchName){
        return (root, query, cb) -> cb.equal(root.get("firstName"), matchName);
    }

    public static Specification getByLastName(String matchName){
        return (root, query, cb) -> cb.equal(root.get("lastName"), matchName);
    }

    public static Specification<User> getByFirstAndLast(String first, String last){
        return Specifications.where(getByFirstName(first)).and(getByLastName(last));
    }
}
