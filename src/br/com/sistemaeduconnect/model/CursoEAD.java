package br.com.sistemaeduconnect.model;

public class CursoEAD extends Curso {

    private String plataformaVirtual;

    // Construtor
    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {

        super(nome, codigo, cargaHoraria);

        if (plataformaVirtual == null || plataformaVirtual.isBlank()) {
            throw new IllegalArgumentException("A plataforma virtual não pode ser vazia.");
        }

        this.plataformaVirtual = plataformaVirtual;
    }

    // Getter
    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    // Sobrescrevendo o método da classe Curso
    @Override
    public void detalharCurso() {
        System.out.println("\n=============== CURSO EAD ===============");
        System.out.println("Curso: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Carga horária: " + getCargaHoraria() + " horas");
        System.out.println("Plataforma virtual: " + plataformaVirtual);
        System.out.println("Modalidade: Ensino a Distância");
        System.out.println("=========================================");
    }
}
