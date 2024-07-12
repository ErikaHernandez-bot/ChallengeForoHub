package com.finalAPI.finalrestAPI.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long> {
    UserDetails findByLogin(String username);
}
