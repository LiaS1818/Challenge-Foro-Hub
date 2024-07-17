package foro.hub.api2.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosCrearCurso(
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
) {
}
