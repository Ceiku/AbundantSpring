package com.example.Service.ModelService;

import com.example.Model.GrantedRole;
import com.example.Model.Repository.GrantedRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Daniel on 13.03.2016.
 */
@Component
public class GrantedRoleService {

    @Autowired
    private GrantedRoleRepository grantedRoleRepository;

    public GrantedRole save(final GrantedRole grantedRole){return grantedRoleRepository.save(grantedRole);}

    public List<GrantedRole> findAll(){return grantedRoleRepository.findAll();}

    public GrantedRole findOne(final long id){return grantedRoleRepository.findOne(id);}

    public long delete(final long id){return grantedRoleRepository.removeById(id);}
}
