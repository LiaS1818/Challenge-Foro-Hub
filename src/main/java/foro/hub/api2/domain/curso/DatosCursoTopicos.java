package foro.hub.api2.domain.curso;


import foro.hub.api2.domain.topico.DatosTopico;
import org.springframework.data.domain.Page;

public record DatosCursoTopicos(DatosCurso curso, Page<DatosTopico> topicos) {


}
