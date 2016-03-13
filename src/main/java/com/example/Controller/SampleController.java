package com.example.Controller;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Daniel on 13.03.2016.
 */
@RestController
@RequestMapping("/") // Home
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SampleController extends TemplateAauthController {

    @RequestMapping("/out")
    public Principal name(Principal principal){

        iPreAuthorize().isAdmin();
        return principal;
    }
}
