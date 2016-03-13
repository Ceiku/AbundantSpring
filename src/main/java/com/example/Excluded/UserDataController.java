package com.example.Excluded;

import com.example.Service.IContract.IUserDataMethodAuthorities;
import com.example.Service.Implementations.UserDataRepositoryService;
import com.example.Excluded.UserData;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import com.google.api.services.oauth2.model.Userinfoplus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Daniel on 13.03.2016.
 */

@Configuration
@RestController
@RequestMapping("/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserDataController {

    @Autowired
    OAuth2ClientContext clientContext;

    @Autowired
    private UserDataRepositoryService userDataRepositoryService;


    // Here I don't @requestbody and have user creation at it's own sub-path, neat!
    @RequestMapping("/create_new")
    public String CreateUser(){
        GoogleCredential userCredentials = new GoogleCredential();
        userCredentials.setAccessToken(clientContext.getAccessToken().getValue());

        Oauth2 clientBuild =  new Oauth2.Builder
                (new NetHttpTransport(), new JacksonFactory(), userCredentials).setApplicationName("Name_of_App").build();

         Userinfoplus userinfoplus = null;

        try {
            userinfoplus = clientBuild.userinfo().get().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }



        // TODO ! Checker
        UserData newUser = new UserData(clientContext.getAccessToken().getValue(),userinfoplus);



        //userDataRepositoryService.save(newUser);
        return "new user: " + newUser.getId();
    }





}
