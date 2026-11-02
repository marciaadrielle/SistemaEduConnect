package br.com.sistemaeduconnect.repository;

import br.com.sistemaeduconnect.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma>turmas = new ArrayList<>();


    //Método para salvar uma turma
    public void salvarTurma(Turma turma){
        turmas.add(turma);
    }

    //Método para listar as turmas salvas
    public List<Turma> listarTodasTurmas(){
        return new ArrayList<>(turmas);
    }

    //Método para buscar turma pelo código
    public Turma buscarPorCodigo(String codigo){
        for (Turma turma : turmas){
            if (turma.getCodigo().equals(codigo)){
                return turma;
            }
        }
        return null;
    }
}

