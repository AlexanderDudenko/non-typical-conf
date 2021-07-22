package com.somecompany.someproject.web.handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final String LOGOUT_URL = "/controller/logout";

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        System.out.println("Logout ...");
        response.sendRedirect(request.getContextPath() + LOGOUT_URL);
    }
}
