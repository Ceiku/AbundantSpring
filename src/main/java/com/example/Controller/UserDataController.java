package com.example.Controller;

import com.example.Model.Exceptions.UnsupportedMethodException;
import com.example.Model.UserData;
import com.example.Service.ModelService.UserDataService;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Daniel on 13.03.2016.
 */

@RestController
@RequestMapping("/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserDataController extends TemplateAauthController{

    @Autowired
    OAuth2ClientContext clientContext;

    @Autowired
    private UserDataService userDataService;

    @RequestMapping("/create_new")
    public Userinfoplus CreateUser(){
        GoogleCredential userCredentials = new GoogleCredential();
        userCredentials.setAccessToken(clientContext.getAccessToken().getValue());

        Oauth2 clientBuild =  new Oauth2.Builder
                (new NetHttpTransport(), new JacksonFactory(), userCredentials).setApplicationName("Name_of_App").build();

        Userinfoplus userinfoplus = null;
        /* throws nullpointer exception
        * if (!(userDataService.findOne(userinfoplus.getId()) == null))
            throw new UnsupportedMethodException("No more information Aviable");*/

        try {
            userinfoplus = clientBuild.userinfo().get().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!(userDataService.findOne(userinfoplus.getId()) == null))
            throw new UnsupportedMethodException("No more information Aviable");


        // TODO ! Checker
        UserData newUser = new UserData(clientContext.getAccessToken().getValue(),userinfoplus);

        userDataService.save(newUser);
        System.out.println(newUser.getRoles());
        return userinfoplus;
    }
}
