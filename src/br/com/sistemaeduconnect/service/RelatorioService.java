package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Aluno;
import br.com.sistemaeduconnect.model.Curso;
import br.com.sistemaeduconnect.model.Professor;
import br.com.sistemaeduconnect.model.Relatorio;
import br.com.sistemaeduconnect.repository.AlunoRepository;
import br.com.sistemaeduconnect.repository.CursoRepository;
import br.com.sistemaeduconnect.repository.ProfessorRepository;
import br.com.sistemaeduconnect.repository.TurmaRepository;

import java.util.ArrayList;
import java.util.List;

public class RelatorioService {
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private CursoRepository cursoRepository;

    public RelatorioService(AlunoRepository alunoRepository,
                            ProfessorRepository professorRepository,
                            CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
    }

    public void gerarRelatorioGeral() {
        List<Relatorio> relatorios = new ArrayList<>();

        // Adicionamos os alunos.
        relatorios.addAll(alunoRepository.listarTodosAlunos());

        // Adicionamos os professores.
        relatorios.addAll(professorRepository.listarTodosProfessores());

        // Adicionamos os cursos.
        relatorios.addAll(cursoRepository.listarTodosCursos());

        // Percorremos a lista e geramos cada relatório.
        for (Relatorio relatorio : relatorios) {
            relatorio.gerarRelatorio();
        }

    }

    public void gerarRelatorioAlunos(){
        for (Aluno aluno : alunoRepository.listarTodosAlunos()){
            aluno.gerarRelatorio();
        }
    }

    public void gerarRelatorioProfessores() {
        for (Professor professor : professorRepository.listarTodosProfessores()) {
            professor.gerarRelatorio();
        }
    }

    public void gerarRelatorioCursos() {
        for (Curso curso : cursoRepository.listarTodosCursos()) {
            curso.gerarRelatorio();
        }
    }
}
