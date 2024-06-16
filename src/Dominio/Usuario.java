
package Dominio;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private int idTelefone;
    private int idEmail;
    private String login;
    private String senha;
    
    public Usuario() {
        
    }

    public Usuario(int id, String nome, String cpf, int idTelefone, int idEmail, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idTelefone = idTelefone;
        this.idEmail = idEmail;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
