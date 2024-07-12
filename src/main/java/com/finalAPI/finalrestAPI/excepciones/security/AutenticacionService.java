package com.finalAPI.finalrestAPI.excepciones.security;

import com.finalAPI.finalrestAPI.usuarios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {
    @Autowired
    private UsuariosRepositorio usuariosRepositorio;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return usuariosRepositorio.findByLogin(username);
    }
}
