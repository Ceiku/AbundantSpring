package com.example.Controller;

import com.example.Service.SecurityService.IPreAuthorize;
import com.example.Service.SecurityService.IPreAuthorizeImpl;
import org.springframework.context.annotation.Bean;

/**
 * Created by Daniel on 13.03.2016.
 *
 * Inheritors must annotate @EnableGlobalMethodSecurity(prePostEnabled = true) in subclasses
 */
public abstract class TemplateAauthController {

    @Bean
    public IPreAuthorize iPreAuthorize(){return new IPreAuthorizeImpl();}
}
