package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Professor;
import br.com.sistemaeduconnect.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(Professor professor) {
        //valida se já possui um professor com o mesmo numero de registro
        Professor professorEncontrado = professorRepository.buscarPorRegistro(professor.getRegistro());
        if (professorEncontrado != null) {
            throw new IllegalArgumentException("Já possui um professor cadastrado com esse registro.");
        }
        professorRepository.salvarProfessor(professor);
    }

    //Método para listar todos os alunos
    public List<Professor>listarTodosProfessores(){
        return professorRepository.listarTodosProfessores();
    }

    //Método para buscar professor pelo registro
    public Professor buscarProfessorPorRegistro(String registro){
        return  professorRepository.buscarPorRegistro(registro);
    }
}

