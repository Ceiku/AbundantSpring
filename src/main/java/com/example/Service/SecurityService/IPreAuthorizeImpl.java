package com.example.Service.SecurityService;

/**
 * Created by Daniel on 13.03.2016.
 * Not like these values ever get's returned when it's sensible, @PreAuth catches them.
 */
public class IPreAuthorizeImpl implements IPreAuthorize {
    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public boolean isSupervisor() {
        return true;
    }

    @Override
    public boolean isUser() {
        return true;
    }
}
