package br.com.sistemaeduconnect.repository;

import br.com.sistemaeduconnect.model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();


    //Método para salvar um aluno na lista
    public void salvarProfessor(Professor professor) {
        professores.add(professor);
    }

    //Método para listar os alunos salvos
    public List<Professor> listarTodosProfessores() {
        return new ArrayList<>(professores);
    }

    //Método para buscar aluno pelo registro
    public Professor buscarPorRegistro(String registro) {
        for (Professor professor : professores) {
            if (professor.getRegistro().equals(registro)) {
                return professor;
            }
        }
        return null;
    }
}
