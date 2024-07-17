package foro.hub.api2.domain.curso;


import foro.hub.api2.domain.curso.validaciones.ValidadorCurso;
import foro.hub.api2.domain.topico.DatosTopico;
import foro.hub.api2.domain.topico.TopicoRepository;
import foro.hub.api2.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {



    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    private final List<ValidadorCurso> validadorCursos;

    public CursoService(List<ValidadorCurso> validadorCursos) {
        this.validadorCursos = validadorCursos;
    }

    public DatosCurso crearCurso(DatosCrearCurso datos) {
        validadorCursos.forEach(v -> v.validar(datos));
        var curso = new Curso(datos.nombre(), datos.categoria());
        cursoRepository.save(curso);
        return new DatosCurso(curso);
    }

    public DatosCurso actualizarCurso(DatosActualizarCurso datos) {
        cursoExistente(datos.id());
        var curso = cursoRepository.getReferenceById(datos.id());
        curso.actualizar(datos);
        return new DatosCurso(curso);
    }

    public DatosCurso cambiarEstado(Long id) {
        cursoExistente(id);
        var curso = cursoRepository.getReferenceById(id);
        curso.setActivo();
        return new DatosCurso(curso);
    }

    private void cursoExistente(Long id) {
        if (id == null) {
            throw new ValidationException("Deve proporcionar el id del curso");
        }

        if (!cursoRepository.existsById(id)) {
            throw new ValidacionDeIntegridad("Debe proporcionar el ID de curso valido");
        }
    }

    public Page<DatosCurso> listarCursosActivos(Pageable paginacion) {
        return cursoRepository.findByActivoTrue(paginacion).map(DatosCurso::new);
    }

    public Page<DatosCurso> listarCursosInactivos(Pageable paginacion) {
        return cursoRepository.findByActivoFalse(paginacion).map(DatosCurso::new);
    }

    public Page<DatosCurso> listarCursos(Pageable paginacion) {
        return cursoRepository.findAll(paginacion).map(DatosCurso::new);
    }

    public DatosCursoTopicos mostrarCurso(Long id, Pageable paginacion) {
        cursoExistente(id);
        Curso curso = cursoRepository.getReferenceById(id);
        var topicos = topicoRepository.findAllByCurso(curso, paginacion).map(DatosTopico::new);
        return new DatosCursoTopicos(new DatosCurso(curso), topicos);
    }
}
