package com.finalAPI.finalrestAPI.topicos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name="topicos")
//Estamos asignando una entidad JPA
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    @Column(name = "fechacreacion")
    private Timestamp fechacreacion;
    //private LocalDateTime fechacreacion;
    @JsonIgnore
    private boolean activo;
    @Enumerated(EnumType.STRING)
    private Status status;



    public Topicos(DatosRegistrosTopicos datosRegistrosTopicos) {
        this.titulo=datosRegistrosTopicos.titulo();
        this.mensaje=datosRegistrosTopicos.mensaje();
        this.autor=datosRegistrosTopicos.autor();
        this.curso=datosRegistrosTopicos.curso();
        this.fechacreacion= Timestamp.valueOf(LocalDateTime.now());
        this.status=status.INACTIVO;
        this.activo=true;
    }





    /*public void actualizarDatos(DatosActualizarTopicos datosActualizarTopicos) {
        if (datosActualizarTopicos.titulo() != null) {
            this.titulo = datosActualizarTopicos.titulo();
        }
        if (datosActualizarTopicos.mensaje() != null) {
            this.mensaje = datosActualizarTopicos.mensaje();
        }
        if (datosActualizarTopicos.autor() != null) {
            this.autor = datosActualizarTopicos.autor();
        }
        if (datosActualizarTopicos.curso() != null) {
            this.curso = datosActualizarTopicos.curso();
        }
    }*/
    public void actualizarDatos(DatosRegistrosTopicos datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.autor() != null) {
            this.autor = datos.autor();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }

/*
    public void desactivarTopicos() {
        this.activo = false;
    }
    */


}
