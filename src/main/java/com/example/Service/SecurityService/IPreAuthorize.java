package com.example.Service.SecurityService;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Daniel on 13.03.2016.
 */
public interface IPreAuthorize {

    @PreAuthorize("hasRole('ADMIN')")
    boolean isAdmin();

    @PreAuthorize("hasRole('SUPERVISOR')")
    boolean isSupervisor();

    @PreAuthorize("hasRole('USER')")
    boolean isUser();
}
