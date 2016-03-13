package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniel on 13.03.2016.
 */
@Data
@Entity
@NoArgsConstructor
public class GrantedRole implements GrantedAuthority{

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String authority;
    @ManyToMany
    @JsonIgnore
    private List<UserData> users;

    public GrantedRole(String authority){
        setAuthority(authority);
    }

}
