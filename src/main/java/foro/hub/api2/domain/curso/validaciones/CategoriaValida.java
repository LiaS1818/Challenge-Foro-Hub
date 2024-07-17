package foro.hub.api2.domain.curso.validaciones;


import foro.hub.api2.domain.curso.DatosCrearCurso;
import foro.hub.api2.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValida implements ValidadorCurso{


    @Override
    public void validar(DatosCrearCurso datos) {
        if (datos.categoria() == null) {
            throw new ValidacionDeIntegridad("Debe asignarle una categoria al curso");
        }
        //Validar Enum

    }
}
