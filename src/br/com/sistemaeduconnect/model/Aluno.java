package br.com.sistemaeduconnect.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes;



    //Construtor
    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
    }


    //Getters
    public String getMatricula() {
        return matricula;
    }
    public Curso getCurso() {
        return curso;
    }
    public List<Avaliacao> getAvaliacoes() {
        return new ArrayList<>(avaliacoes);
    }

    //Método para adicionar a avaliação ao aluno
    public void adicionarAvaliacao(Avaliacao avaliacao){
        if(avaliacao == null){
            throw new IllegalArgumentException("A avaliação não pode ser nula");
        }
        avaliacoes.add(avaliacao);
    }


}
