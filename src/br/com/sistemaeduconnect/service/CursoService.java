package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Curso;
import br.com.sistemaeduconnect.repository.CursoRepository;

import java.util.List;

public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //Método para cadastrar o curso
    public void cadastrarCurso(Curso curso) {
        //valida se já tem o curso cadastrado
        Curso cursoEncontrado = cursoRepository.buscarCursoPorCodigo(curso.getCodigo());
        if (cursoEncontrado != null) {
            throw new IllegalArgumentException("Já possui um curso cadastrado com esse código");
        }
        cursoRepository.salvarCurso(curso);
    }

    //Metod oara listar todos os cursos
    public List<Curso> listarTodosCursos(){
        return cursoRepository.listarTodosCursos();
    }

    //Metodo para buscar cursos pelo codigo
    public Curso buscarCursoPorCodigo(String codigo){
        return cursoRepository.buscarCursoPorCodigo(codigo);
    }
}