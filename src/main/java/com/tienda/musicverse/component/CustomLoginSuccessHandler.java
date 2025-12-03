package com.tienda.musicverse.component;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Obtener los roles del usuario
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Redirigir según el rol
        for (GrantedAuthority auth : authorities) {
            String role = auth.getAuthority();
            System.out.println(role);
            if ("ROLE_Admin".equals(role)) {
                response.sendRedirect("");
                return;
            }
            else if ("ROLE_Usuario".equals(role)) {
                response.sendRedirect("");
                return;
            }
            else {
                response.sendRedirect("");
                return;
            }
        }

        // Si no tiene ningún rol conocido
        response.sendRedirect("/auth/login?error");
    }
}
