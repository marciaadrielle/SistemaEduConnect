
package br.com.sistemaeduconnect.service;

import br.com.sistemaeduconnect.model.Aluno;
import br.com.sistemaeduconnect.model.Professor;
import br.com.sistemaeduconnect.model.Turma;
import br.com.sistemaeduconnect.repository.AlunoRepository;
import br.com.sistemaeduconnect.repository.ProfessorRepository;
import br.com.sistemaeduconnect.repository.TurmaRepository;

import java.util.List;

public class TurmaService {

    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private TurmaRepository turmaRepository;

    public TurmaService(AlunoRepository alunoRepository,
                        ProfessorRepository professorRepository,
                        TurmaRepository turmaRepository) {

        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
    }

    // Cadastrar turma
    public void cadastrarTurma(Turma turma) {

        Turma turmaEncontrada =
                turmaRepository.buscarTurmaPorCodigo(turma.getCodigo());

        if (turmaEncontrada != null) {
            throw new IllegalArgumentException(
                    "Já existe uma turma cadastrada com esse código");
        }

        turmaRepository.salvarTurma(turma);
    }

    // Listar todas as turmas
    public List<Turma> listarTodasTurmas() {
        return turmaRepository.listarTodasTurmas();
    }

    // Buscar turma pelo código
    public Turma buscarTurmaPorCodigo(String codigo) {
        return turmaRepository.buscarTurmaPorCodigo(codigo);
    }

    // Associar professor à turma
    public void associarProfessor(String codigoTurma, String registroProfessor) {

        Turma turma = turmaRepository.buscarTurmaPorCodigo(codigoTurma);

        if (turma == null) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }

        Professor professor =
                professorRepository.buscarPorRegistro(registroProfessor);

        if (professor == null) {
            throw new IllegalArgumentException("Professor não encontrado.");
        }

        turma.setProfessor(professor);
    }

    // Associar aluno à turma
    public void associarAluno(String codigoTurma, String matriculaAluno) {

        Turma turma = turmaRepository.buscarTurmaPorCodigo(codigoTurma);

        if (turma == null) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }

        Aluno aluno = alunoRepository.buscarPorMatricula(matriculaAluno);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        turma.adicionarAluno(aluno);
    }
}
