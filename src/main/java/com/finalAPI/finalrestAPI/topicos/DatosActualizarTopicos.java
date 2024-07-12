package com.finalAPI.finalrestAPI.topicos;
import jakarta.validation.constraints.NotBlank;
public record DatosActualizarTopicos(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso
        ) {
}
