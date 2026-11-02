package br.com.sistemaeduconnect.service;

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
    private TurmaRepository turmaRepository;
    private CursoRepository cursoRepository;

    public RelatorioService(AlunoRepository alunoRepository, ProfessorRepository professorRepository,
                            TurmaRepository turmaRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
    }

    public void gerarRelatorioGeral() {
        List<Relatorio> relatorios = new ArrayList<>();


    }
}
