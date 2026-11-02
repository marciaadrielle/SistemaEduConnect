package br.com.sistemaeduconnect.model;

public class Avaliacao {

    private Aluno aluno;
    private Double nota;
    private String descricao;

    // Construtor
    public Avaliacao(String descricao, Aluno aluno) {

        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }

        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        this.aluno = aluno;
        this.descricao = descricao;
    }

    // Método para atribuir e validar a nota
    public void atribuirNota(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.nota = valor;
        System.out.println("Nota " + valor + " atribuída ao aluno " + aluno.getNome() + ".");
    }


    // Getters
    public Double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    // Exibe os dados da avaliação
    public void exibirAvaliacao() {
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Descrição: " + descricao);
        if (nota == null) {
            System.out.println("Nota: Ainda não atribuída.");
        } else {
            System.out.println("Nota: " + nota);
        }

        System.out.println("===================================");
    }
}
