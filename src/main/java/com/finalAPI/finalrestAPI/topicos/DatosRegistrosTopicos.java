package com.finalAPI.finalrestAPI.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DatosRegistrosTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String autor,
        @NotBlank
        String curso

) {// Constructor adicional para permitir construcción sin campos requeridos

        // Métodos para actualización parcial
        public DatosRegistrosTopicos withTitulo(String titulo) {
                return new DatosRegistrosTopicos(
                        titulo,
                        this.mensaje(),
                        this.autor(),
                        this.curso()
                );
        }

        public DatosRegistrosTopicos withMensaje(String mensaje) {
                return new DatosRegistrosTopicos(
                        this.titulo(),
                        mensaje,
                        this.autor(),
                        this.curso()
                );
        }

        public DatosRegistrosTopicos withAutor(String autor) {
                return new DatosRegistrosTopicos(
                        this.titulo(),
                        this.mensaje(),
                        autor,
                        this.curso()
                );
        }

        public DatosRegistrosTopicos withCurso(String curso) {
                return new DatosRegistrosTopicos(
                        this.titulo(),
                        this.mensaje(),
                        this.autor(),
                        curso
                );
        }
}

