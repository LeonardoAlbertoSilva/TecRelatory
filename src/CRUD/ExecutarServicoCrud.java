
package CRUD;

import Dominio.ExecutarServico;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExecutarServicoCrud {
    public void addExecutarServico(ExecutarServico executarServico) {
        String sql = "INSERT INTO Executar_Servico (id_usuario, id_servico, status) VALUES (?, ?, ?)";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, executarServico.getIdUsuario());
            statement.setInt(2, executarServico.getIdServico());
            statement.setString(3, executarServico.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ExecutarServico getExecutarServico(int id) {
        String sql = "SELECT * FROM Executar_Servico WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ExecutarServico executarServico = new ExecutarServico();
                executarServico.setId(resultSet.getInt("id"));
                executarServico.setIdUsuario(resultSet.getInt("id_usuario"));
                executarServico.setIdServico(resultSet.getInt("id_servico"));
                executarServico.setStatus(resultSet.getString("status"));
                return executarServico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExecutarServico> getAllExecutarServicos() {
        String sql = "SELECT * FROM Executar_Servico";
        List<ExecutarServico> executarServicos = new ArrayList<>();
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ExecutarServico executarServico = new ExecutarServico();
                executarServico.setId(resultSet.getInt("id"));
                executarServico.setIdUsuario(resultSet.getInt("id_usuario"));
                executarServico.setIdServico(resultSet.getInt("id_servico"));
                executarServico.setStatus(resultSet.getString("status"));
                executarServicos.add(executarServico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executarServicos;
    }

    public void updateExecutarServico(ExecutarServico executarServico) {
        String sql = "UPDATE Executar_Servico SET id_usuario = ?, id_servico = ?, status = ? WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, executarServico.getIdUsuario());
            statement.setInt(2, executarServico.getIdServico());
            statement.setString(3, executarServico.getStatus());
            statement.setInt(4, executarServico.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExecutarServico(int id) {
        String sql = "DELETE FROM Executar_Servico WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}