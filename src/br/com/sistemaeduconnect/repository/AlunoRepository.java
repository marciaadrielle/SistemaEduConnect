package br.com.sistemaeduconnect.repository;

import br.com.sistemaeduconnect.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();


    //Método para salvar um aluno na lista
    public void salvarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    //Método para listar os alunos salvos
    public List<Aluno> listarTodosAlunos() {
        return new ArrayList<>(alunos);
    }

    //Método para buscar aluno pela matricula
    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
}
