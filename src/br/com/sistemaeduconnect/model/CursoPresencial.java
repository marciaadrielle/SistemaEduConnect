package br.com.sistemaeduconnect.model;


public class CursoPresencial extends Curso {

    private String salaAula;

    // Construtor
    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaAula) {
        super(nome, codigo, cargaHoraria);
        if (salaAula == null || salaAula.isBlank()) {
            throw new IllegalArgumentException("A sala de aula não pode ser vazia.");
        }

        this.salaAula = salaAula;
    }

    // Getter
    public String getSalaAula() {
        return salaAula;
    }

    // Sobrescrevendo o método da classe Curso
    @Override
    public void detalharCurso() {
        System.out.println("\n========== CURSO PRESENCIAL ==========");
        System.out.println("Curso: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Carga horária: " + getCargaHoraria() + " horas");
        System.out.println("Sala de aula: " + salaAula);
        System.out.println("Modalidade: Presencial");
        System.out.println("======================================");
    }
}
