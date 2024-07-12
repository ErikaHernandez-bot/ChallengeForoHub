package com.finalAPI.finalrestAPI.topicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository <Topicos, Long > {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
    Page<Topicos> findByActivoTrue(Pageable paginacion);
}
