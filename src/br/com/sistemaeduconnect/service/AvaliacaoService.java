package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Aluno;
import br.com.sistemaeduconnect.model.Avaliacao;
import br.com.sistemaeduconnect.repository.AlunoRepository;

public class AvaliacaoService {
    private AlunoRepository alunoRepository;

    public AvaliacaoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void registrarAvaliacao(String matricula, String descricao, double nota) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado para a matrícula: " + matricula);
        }
        Avaliacao avaliacao = new Avaliacao(descricao, aluno);
        avaliacao.atribuirNota(nota);
        aluno.adicionarAvaliacao(avaliacao);


    }


}
