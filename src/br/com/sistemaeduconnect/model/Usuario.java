package br.com.sistemaeduconnect.model;
public abstract class Usuario implements Autenticacao{

    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }
    @Override
    public boolean autenticar(String login, String senha){
        return this.login.equals(login)&&validarSenha(senha);
    }


    protected boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }
}