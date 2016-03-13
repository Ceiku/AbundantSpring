package com.example.Excluded;

import com.example.Excluded.Role;
import com.example.Excluded.IRoleService;
import com.example.Excluded.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Daniel on 13.03.2016.
 */
@RestController
@RequestMapping("/role")
public class Rolecontroller {

    @Autowired
    private IRoleService iRoleService(){return new RoleService();}

    @RequestMapping(method = RequestMethod.POST)
    public String createRole(@RequestBody Role role) {
        iRoleService().save(role);
        return role.getAuthority();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> findAll() {
        return iRoleService().findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role findById(@PathVariable String id) {
        return iRoleService().findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String removeById(@PathVariable String id) {
        iRoleService().removeById(id);
        return id;
    }
}
