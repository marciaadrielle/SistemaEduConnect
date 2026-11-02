package br.com.sistemaeduconnect.repository;

import br.com.sistemaeduconnect.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso>cursos = new ArrayList<>();

    //Método para salvar os curso
    public void salvarCurso(Curso curso){
        cursos.add(curso);
    }

    //Método para listar todos os cursos
    public List<Curso>listarTodosCursos(){
        return new ArrayList<>(cursos);
    }

    //Método para buscar o curso pelo código
    public Curso buscarCursoPorCodigo(String codigo){
        for(Curso curso : cursos){
            if (curso.getCodigo().equals(codigo)){
                return curso;
            }
        }
        return null;
    }
}
