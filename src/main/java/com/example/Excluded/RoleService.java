package com.example.Excluded;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Daniel on 13.03.2016.
 */
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;

    public String removeById(String id) {
        return repository.removeById(id);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findOne(String id) {
        return repository.findOne(id);
    }

    public void save(Role role) {
        repository.save(role);
    }
}
