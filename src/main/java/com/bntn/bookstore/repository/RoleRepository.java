package com.bntn.bookstore.repository;

import com.bntn.bookstore.model.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByname(String name);
}
