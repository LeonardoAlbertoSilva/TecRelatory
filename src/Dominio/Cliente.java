package Dominio;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private int idEndereco;
    private int idTelefone;
    private int idEmail;
    
    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, int idEnd, int idTel, int idEm) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idEndereco = idEnd;
        this.idTelefone = idTel;
        this.idEmail = idEm;
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

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
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
}
