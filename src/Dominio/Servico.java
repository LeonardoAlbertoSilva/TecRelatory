
package Dominio;

import java.time.LocalDate;

public class Servico {
    private int id;
    private int idCliente;
    private LocalDate dataInicio;
    private String descricaoProblema;
    private byte[] imagemProblema;
    private LocalDate dataFim;
    private String descricaoSolucao;
    private byte[] imagemSolucao;
    private int idMaterial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public byte[] getImagemProblema() {
        return imagemProblema;
    }

    public void setImagemProblema(byte[] imagemProblema) {
        this.imagemProblema = imagemProblema;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }

    public byte[] getImagemSolucao() {
        return imagemSolucao;
    }

    public void setImagemSolucao(byte[] imagemSolucao) {
        this.imagemSolucao = imagemSolucao;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", dataInicio=" + dataInicio +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", dataFim=" + dataFim +
                ", descricaoSolucao='" + descricaoSolucao + '\'' +
                ", idMaterial=" + idMaterial +
                '}';
    }
}
