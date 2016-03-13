package com.example.Excluded;


import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IRoleService {

    @PreAuthorize("hasRole('ROLE_ADMIN') or #userID == principal.getName()")
    String removeById(String id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Role> findAll();

    @PreAuthorize("hasRole('ROLE_ADMIN') or #userID == principal.getName()")
    Role findOne(String id);

    void save(final Role role);
}
