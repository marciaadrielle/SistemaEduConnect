import br.com.sistemaeduconnect.repository.*;
import br.com.sistemaeduconnect.service.*;
import br.com.sistemaeduconnect.ui.MenuUI;

public class Main {

    public static void main(String[] args) {

        // 1. Instanciar os repositórios
        AlunoRepository alunoRepository = new AlunoRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        CursoRepository cursoRepository = new CursoRepository();
        TurmaRepository turmaRepository = new TurmaRepository();

        // 2. Instanciar os serviços
        AlunoService alunoService = new AlunoService(alunoRepository);

        ProfessorService professorService =
                new ProfessorService(professorRepository);

        CursoService cursoService =
                new CursoService(cursoRepository);

        TurmaService turmaService = new TurmaService(
                alunoRepository,
                professorRepository,
                turmaRepository
        );

        AvaliacaoService avaliacaoService =
                new AvaliacaoService(alunoRepository);

        RelatorioService relatorioService = new RelatorioService(
                alunoRepository,
                professorRepository,
                cursoRepository
        );

        // 3. Instanciar a interface do usuário
        MenuUI menu = new MenuUI(
                alunoService,
                professorService,
                cursoService,
                turmaService,
                avaliacaoService,
                relatorioService
        );

        // 4. Iniciar o sistema
        menu.exibirMenu();
    }
}
