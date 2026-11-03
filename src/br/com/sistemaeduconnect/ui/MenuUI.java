package br.com.sistemaeduconnect.ui;

import br.com.sistemaeduconnect.model.*;
import br.com.sistemaeduconnect.service.*;

import java.util.Scanner;

public class MenuUI {
    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final TurmaService turmaService;
    private final AvaliacaoService avaliacaoService;
    private final RelatorioService relatorioService;

    private final Scanner leitura;

    public MenuUI(AlunoService alunoService, ProfessorService professorService,
                  CursoService cursoService, TurmaService turmaService,
                  AvaliacaoService avaliacaoService, RelatorioService relatorioService){
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
        this.avaliacaoService = avaliacaoService;
        this.relatorioService = relatorioService;
        this.leitura = new Scanner(System.in);
    }
    public void exibirMenu(){
        int opcao = -1;
        do {
            System.out.println("\n========================================");
            System.out.println("   EDUCONNECT: SISTEMA DE GESTÃO EDUCACIONAL");
            System.out.println("========================================");
            System.out.println("1. Cadastrar Curso (Presencial / EAD)");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Aluno");
            System.out.println("4. Criar Turmas");
            System.out.println("5. Registrar Avaliação (Nota)");
            System.out.println("6. Relatório de Alunos");
            System.out.println("7. Relatório de Professores");
            System.out.println("8. Relatório de Cursos");
            System.out.println("9. Relatório Geral");
            System.out.println("10. Associar aluno à turma");
            System.out.println("11. Associar professor à turma");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!leitura.hasNextInt()) {
                System.out.print("Por favor, digite um número válido: ");
                leitura.next();
            }
            opcao = leitura.nextInt();
            leitura.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("\n===== CADASTRO DE CURSO =====");

                        System.out.println("Digite o nome do curso: ");
                        String nome = leitura.nextLine();

                        System.out.println("Digite o código do curso: ");
                        String codigo = leitura.nextLine();

                        System.out.println("Digite a carga horária do curso: ");
                        int cargaHoraria = Integer.parseInt(leitura.nextLine());

                        System.out.println("MODALIDADES DISPONÍVEIS: ");
                        System.out.println("1 - Presencial ");
                        System.out.println("2 - EAD");
                        System.out.println("Escolha a modalidade: ");
                        int modalidade = Integer.parseInt(leitura.nextLine());

                        Curso curso;
                        if (modalidade == 1) {
                            System.out.println("Digite qual a sala de aula do curso: ");
                            String sala = leitura.nextLine();

                            curso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
                        } else if (modalidade == 2) {
                            System.out.println("Digite qual a plataforma virtual do curso: ");
                            String plataforma = leitura.nextLine();

                            curso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
                        } else {
                            System.out.println("modalidade inválida!");
                            break;
                        }

                        cursoService.cadastrarCurso(curso);
                        System.out.println("curso cadastrado com sucesso");
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Erro ao cadastrar curso: " + e.getMessage());
                    }

                    break;
                case 2:

                    try{
                        System.out.println("\n===== CADASTRAR PROFESSOR =====");
                        System.out.println("Digite o nome do professor: ");
                        String nome = leitura.nextLine();

                        System.out.println("Digite o login do professor");
                        String login = leitura.nextLine();

                        System.out.println("Digite a senha: ");
                        String senha = leitura.nextLine();

                        System.out.println("Digite a especialidade do professor");
                        String especialidade = leitura.nextLine();

                        System.out.println("Digite o registro do professor: ");
                        String registro = leitura.nextLine();

                        Professor professor = new Professor(nome, login, senha, especialidade, registro);
                        professorService.cadastrarProfessor(professor);
                        System.out.println("Professor cadastrado com sucesso!");

                    }catch (IllegalArgumentException e){
                        System.out.println("Erro ao cadastrar professor: " + e.getMessage());
                    }

                    break;
                case 3:
                    if (cursoService.listarTodosCursos().isEmpty()) {
                        System.out.println("Não existem cursos cadastrados.");
                        System.out.println("Cadastre um curso antes de cadastrar alunos.");
                        break;
                    }
                    try {
                        System.out.println("\n===== CADASTRO DE ALUNO =====");

                        System.out.print("Digite o nome do aluno: ");
                        String nome = leitura.nextLine();

                        System.out.print("Digite o login de acesso do aluno: ");
                        String login = leitura.nextLine();

                        System.out.print("Digite a senha: ");
                        String senha = leitura.nextLine();

                        System.out.print("Digite a matrícula: ");
                        String matricula = leitura.nextLine();

                        System.out.print("Digite o código do curso: ");
                        String codigoCurso = leitura.nextLine();

                        Curso curso = cursoService.buscarCursoPorCodigo(codigoCurso);


                        if (curso == null) {
                            System.out.println("Curso não encontrado!");
                            break;
                        }

                        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);

                        alunoService.cadastrarAluno(aluno);

                        System.out.println("Aluno cadastrado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                    }
                    break;


                case 4:
                    try {
                        System.out.println("\n===== CADASTRO DE TURMA =====");

                        System.out.print("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        System.out.print("Digite o registro do professor: ");
                        String registroProfessor = leitura.nextLine();

                        Professor professor = professorService.buscarProfessorPorRegistro(registroProfessor);

                        if (professor == null) {
                            System.out.println("Professor não encontrado! Cadastre o professor primeiro.");
                            break;
                        }

                        System.out.print("Digite o código do curso: ");
                        String codigoCurso = leitura.nextLine();

                        Curso curso = cursoService.buscarCursoPorCodigo(codigoCurso);

                        if (curso == null) {
                            System.out.println("Curso não encontrado! Cadastre o curso primeiro.");
                            break;
                        }

                        Turma turma = new Turma(codigoTurma, professor, curso);

                        turmaService.cadastrarTurma(turma);

                        System.out.println("Turma cadastrada com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar turma: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("\n===== REGISTRAR AVALIAÇÃO =====");

                        System.out.print("Digite a matrícula do aluno: ");
                        String matricula = leitura.nextLine();

                        Aluno aluno = alunoService.buscarAlunoPorMatricula(matricula);

                        if (aluno == null) {
                            System.out.println("Aluno não encontrado!");
                            break;
                        }

                        System.out.print("Digite a descrição da avaliação: ");
                        String descricao = leitura.nextLine();

                        System.out.print("Digite a nota do aluno (0 a 10): ");
                        double nota = Double.parseDouble(leitura.nextLine());

                        avaliacaoService.registrarAvaliacao(matricula, descricao, nota);

                        System.out.println("Avaliação registrada com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao registrar avaliação: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\n===== RELATÓRIO DE ALUNOS =====");
                    relatorioService.gerarRelatorioAlunos();
                    break;

                case 7:
                    System.out.println("\n===== RELATÓRIO DE PROFESSORES =====");
                    relatorioService.gerarRelatorioProfessores();
                    break;

                case 8:
                    System.out.println("\n===== RELATÓRIO DE CURSOS =====");
                    relatorioService.gerarRelatorioCursos();
                    break;

                case 9:
                    System.out.println("\n===== RELATÓRIO GERAL =====");
                    relatorioService.gerarRelatorioGeral();
                    break;

                case 10:
                    try {
                        System.out.println("\n===== ASSOCIAR ALUNO À TURMA =====");

                        System.out.print("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        System.out.print("Digite a matrícula do aluno: ");
                        String matriculaAluno = leitura.nextLine();

                        turmaService.associarAluno(codigoTurma, matriculaAluno);

                        System.out.println("Aluno associado à turma com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao associar aluno: " + e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        System.out.println("\n===== ASSOCIAR PROFESSOR À TURMA =====");

                        System.out.print("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        System.out.print("Digite o registro do professor: ");
                        String registroProfessor = leitura.nextLine();

                        turmaService.associarProfessor(codigoTurma, registroProfessor);

                        System.out.println("Professor associado à turma com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao associar professor: " + e.getMessage());
                    }
                    break;




                case 0:
                    System.out.println("Saindo do sistema EduConnect. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

    }
}