package com.finalAPI.finalrestAPI.excepciones.security;

import com.finalAPI.finalrestAPI.usuarios.UsuariosRepositorio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuariosRepositorio usuariosRepositorio;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Imprimir el token del header
        var authHeader=request.getHeader("Authorization");//.replace("Bearer ","");
        if(authHeader!=null){
            //si no llega nulo reemplazamos el token
            var token = authHeader.replace("Bearer ","");
            var subject = tokenService.getSubject(token);
            if(subject!=null){
                //Token valido
                var usuario = usuariosRepositorio.findByLogin(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario,null,
                        usuario.getAuthorities());//Se forza el inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

}
