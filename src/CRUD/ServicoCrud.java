package CRUD;

import Dominio.Servico;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicoCrud {

    public void addServico(Servico servico) {
        String sql = "INSERT INTO Servico (id_cliente, data_inicio, descricao_problema, imagem_problema, data_fim, descricao_solucao, imagem_solucao, id_material) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, servico.getIdCliente());
            statement.setDate(2, Date.valueOf(servico.getDataInicio()));
            statement.setString(3, servico.getDescricaoProblema());
            statement.setBytes(4, servico.getImagemProblema());
            statement.setDate(5, servico.getDataFim() != null ? Date.valueOf(servico.getDataFim()) : null);
            statement.setString(6, servico.getDescricaoSolucao());
            statement.setBytes(7, servico.getImagemSolucao());
            statement.setInt(8, servico.getIdMaterial());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo Servico foi inserido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Servico getServico(int id) {
        String sql = "SELECT * FROM Servico WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Servico servico = new Servico();
                servico.setId(resultSet.getInt("id"));
                servico.setIdCliente(resultSet.getInt("id_cliente"));
                servico.setDataInicio(resultSet.getDate("data_inicio").toLocalDate());
                servico.setDescricaoProblema(resultSet.getString("descricao_problema"));
                servico.setImagemProblema(resultSet.getBytes("imagem_problema"));
                Date dataFim = resultSet.getDate("data_fim");
                if (dataFim != null) {
                    servico.setDataFim(dataFim.toLocalDate());
                }
                servico.setDescricaoSolucao(resultSet.getString("descricao_solucao"));
                servico.setImagemSolucao(resultSet.getBytes("imagem_solucao"));
                servico.setIdMaterial(resultSet.getInt("id_material"));
                return servico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Servico> getAllServicos() {
        String sql = "SELECT * FROM Servico";
        List<Servico> servicos = new ArrayList<>();
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setId(resultSet.getInt("id"));
                servico.setIdCliente(resultSet.getInt("id_cliente"));
                servico.setDataInicio(resultSet.getDate("data_inicio").toLocalDate());
                servico.setDescricaoProblema(resultSet.getString("descricao_problema"));
                servico.setImagemProblema(resultSet.getBytes("imagem_problema"));
                Date dataFim = resultSet.getDate("data_fim");
                if (dataFim != null) {
                    servico.setDataFim(dataFim.toLocalDate());
                }
                servico.setDescricaoSolucao(resultSet.getString("descricao_solucao"));
                servico.setImagemSolucao(resultSet.getBytes("imagem_solucao"));
                servico.setIdMaterial(resultSet.getInt("id_material"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicos;
    }

    public void updateServico(Servico servico) {
        String sql = "UPDATE Servico SET id_cliente = ?, data_inicio = ?, descricao_problema = ?, imagem_problema = ?, data_fim = ?, descricao_solucao = ?, imagem_solucao = ?, id_material = ? WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, servico.getIdCliente());
            statement.setDate(2, Date.valueOf(servico.getDataInicio()));
            statement.setString(3, servico.getDescricaoProblema());
            statement.setBytes(4, servico.getImagemProblema());
            statement.setDate(5, servico.getDataFim() != null ? Date.valueOf(servico.getDataFim()) : null);
            statement.setString(6, servico.getDescricaoSolucao());
            statement.setBytes(7, servico.getImagemSolucao());
            statement.setInt(8, servico.getIdMaterial());
            statement.setInt(9, servico.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteServico(int id) {
        String sql = "DELETE FROM Servico WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}