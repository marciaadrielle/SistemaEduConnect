package br.com.sistemaeduconnect.model;

public class Curso implements Relatorio{
    private String nome;
    private String codigo;
    private int cargaHoraria;

    // Método para validar campos String
    private void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Método para validar carga horária
    private void validarCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        }
    }

    // Construtor
    public Curso(String nome, String codigo, int cargaHoraria) {

        validarCampo(nome, "O nome do curso não pode ser vazio.");
        validarCampo(codigo, "O código não pode ser vazio.");
        validarCargaHoraria(cargaHoraria);

        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCampo(nome, "O nome do curso não pode ser vazio.");
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        validarCampo(codigo, "O código não pode ser vazio.");
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        validarCargaHoraria(cargaHoraria);
        this.cargaHoraria = cargaHoraria;
    }

    // Método para detalhar o curso
    public void detalharCurso() {
        System.out.println("\n============== CURSO ================");
        System.out.println("Curso: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga horária: " + cargaHoraria + " horas");
        System.out.println("========================================");
    }
    @Override
    public void gerarRelatorio() {
        System.out.println("Curso: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga horária: " + cargaHoraria);
        System.out.println("------------------------------------------");
    }
}
