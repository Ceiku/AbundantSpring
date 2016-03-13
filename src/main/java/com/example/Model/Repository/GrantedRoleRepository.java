package com.example.Model.Repository;

import com.example.Model.GrantedRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 13.03.2016.
 */
@Repository
public interface GrantedRoleRepository extends JpaRepository<GrantedRole, Long>{

    long removeById(final long id);
}
