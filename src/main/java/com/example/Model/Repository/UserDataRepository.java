package com.example.Model.Repository;

import com.example.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel on 13.03.2016.
 */
@Repository
public interface UserDataRepository extends JpaRepository<UserData, String>{

    String removeById(String id);
}
