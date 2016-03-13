package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.api.services.oauth2.model.Userinfoplus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Daniel on 12.03.2016.
 */
@Data
@Entity
@Table(name = "userData")
@AllArgsConstructor
public class UserData implements Authentication {

    @Id
    private String id;
    private String accessToken;
    @JsonIgnore
    private String email;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<GrantedRole> roles;

    //private GrantedRole role;

    public UserData(String accessToken, Userinfoplus userinfoplus){
        setId(userinfoplus.getId());
        roles = new ArrayList<>();
        roles.add(new GrantedRole("ROLE_ADMIN"));
        roles.add(new GrantedRole("ROLE_USER"));

        setAccessToken(accessToken);
        setEmail(userinfoplus.getEmail());
    }
    protected UserData(){}

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public Object getCredentials() {
        return null;
    }

    @JsonIgnore
    @Override
    public Object getDetails() {
        return null;
    }

    @JsonIgnore
    @Override
    public Object getPrincipal() {
        return getId();
    }

    @JsonIgnore
    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @JsonIgnore
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
