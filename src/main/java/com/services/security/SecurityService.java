package com.services.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);

    String getPrincipalName();
}
