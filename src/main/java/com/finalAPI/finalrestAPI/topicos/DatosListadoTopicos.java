package com.finalAPI.finalrestAPI.topicos;

import java.sql.Timestamp;

public record DatosListadoTopicos(
        String titulo,
        String mensaje,
        Timestamp fechacreacion,
        Status status,
        String autor,
        String curso
        ) {

    public DatosListadoTopicos(Topicos topicos){
        this(topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFechacreacion(),
                topicos.getStatus(),
                topicos.getAutor(),
                topicos.getCurso());

    }
}
