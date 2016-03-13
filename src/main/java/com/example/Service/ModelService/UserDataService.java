package com.example.Service.ModelService;

import com.example.Model.Repository.UserDataRepository;
import com.example.Model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Daniel on 13.03.2016.
 */
@Component
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public UserData save(final UserData userData){return userDataRepository.save(userData);}

    public List<UserData> findAll(){return userDataRepository.findAll();}

    public UserData findOne(final String id){return userDataRepository.findOne(id);}

    public String delete(final String id){return userDataRepository.removeById(id);}
}
