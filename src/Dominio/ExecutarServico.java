
package Dominio;

public class ExecutarServico {
    private int id;
    private int idUsuario;
    private int idServico;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExecutarServico{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idServico=" + idServico +
                ", status='" + status + '\'' +
                '}';
    }
}
