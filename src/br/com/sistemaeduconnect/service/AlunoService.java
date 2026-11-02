package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Aluno;
import br.com.sistemaeduconnect.repository.AlunoRepository;
import java.util.List;

public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarAluno(Aluno aluno){
        //Valida se já possui um aluno com o mesmo numero de matricula
        Aluno alunoEncontrado = alunoRepository.buscarPorMatricula(aluno.getMatricula());
        if(alunoEncontrado != null){
            throw  new IllegalArgumentException("Já possui um aluno cadastrado com essa matrícula");
        }
        alunoRepository.salvarAluno(aluno);
    }

    //Método para listar todos os alunos
    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.listarTodosAlunos();
    }

    //Método para buscar o aluno pela matricula
    public Aluno buscarAlunoPorMatricula(String matricula){
        return alunoRepository.buscarPorMatricula(matricula);
    }

}
