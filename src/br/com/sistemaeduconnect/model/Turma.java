package br.com.sistemaeduconnect.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    // Método para validar os campos
    private void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Construtor
    public Turma(String codigo, Professor professor, Curso curso) {
        validarCampo(codigo, "O código da turma não pode ser vazio.");
        if (professor == null) {
            throw new IllegalArgumentException("O professor não pode ser nulo.");
        }
        if (curso == null) {
            throw new IllegalArgumentException("O curso não pode ser nulo.");
        }

        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();

    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        validarCampo(codigo, "O código da turma não pode ser vazio.");
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("O professor não pode ser nulo.");
        }
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("O curso não pode ser nulo.");
        }
        this.curso = curso;
    }

    public List<Aluno> getListaAlunos() {
        return new ArrayList<>(listaAlunos);
    }

    // Método para adicionar um aluno na lista
    public void adicionarAluno(Aluno aluno) {

        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }
        if (listaAlunos.contains(aluno)) {
            throw new IllegalArgumentException("Este aluno já está matriculado na turma.");
        }

        listaAlunos.add(aluno);

        System.out.println("Aluno " + aluno.getNome() +
                " adicionado à turma " + codigo + ".");
    }

    // Método para remover um aluno da lista
    public void removerAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        if (listaAlunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() +
                    " removido da turma " + codigo + ".");
        } else {
            System.out.println("Aluno não encontrado nesta turma.");
        }
    }

    // Método para mostrar o resumo da turma
    public void mostrarResumo() {
        System.out.println("========================================");
        System.out.println("Turma: " + codigo);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Quantidade de Alunos Matriculados: " +
                listaAlunos.size());

        System.out.println("=========================================");

        //Exibindo as avaliações no resumo ---
        System.out.println("=========== AVALIAÇÕES DA TURMA ===========");

        boolean possuiAvaliacoes = false;

        for (Aluno aluno : listaAlunos) {

            for (Avaliacao avaliacao : aluno.getAvaliacoes()) {

                possuiAvaliacoes = true;

                System.out.println("Aluno: " + aluno.getNome());
                System.out.println("Descrição: " + avaliacao.getDescricao());
                System.out.println("Nota: " + avaliacao.getNota());
                System.out.println("------------------------------------------");
            }
        }

        if (!possuiAvaliacoes) {
            System.out.println("Nenhuma avaliação registrada no momento.");
        }
    }

}
