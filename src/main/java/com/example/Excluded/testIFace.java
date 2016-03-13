package com.example.Excluded;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Daniel on 12.03.2016.
 */
public interface testIFace {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String test();
}
