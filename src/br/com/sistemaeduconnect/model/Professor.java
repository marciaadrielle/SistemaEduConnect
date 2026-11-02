package br.com.sistemaeduconnect.model;

public class Professor extends Usuario{
    private String especialidade;
    private String registro;

    //Construtor
    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }
}
