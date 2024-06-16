
package CRUD;

import Dominio.Cidade;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeCrud {

    public void addCidade(Cidade cidade) {
        String sql = "INSERT INTO Cidade (id_estado, nome) VALUES (?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cidade.getIdEstado());
            stmt.setString(2, cidade.getNome());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cidade getCidade(int id) {
        String sql = "SELECT * FROM Cidade WHERE id = ?";
        Cidade cidade = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("id_estado"));
                cidade.setNome(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }

    public List<Cidade> getAllCidades() {
        String sql = "SELECT * FROM Cidade";
        List<Cidade> cidades = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("id_estado"));
                cidade.setNome(rs.getString("nome"));
                cidades.add(cidade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    public void updateCidade(Cidade cidade) {
        String sql = "UPDATE Cidade SET id_estado = ?, nome = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cidade.getIdEstado());
            stmt.setString(2, cidade.getNome());
            stmt.setInt(3, cidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCidade(int id) {
        String sql = "DELETE FROM Cidade WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
