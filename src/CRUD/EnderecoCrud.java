
package CRUD;

import Dominio.Endereco;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoCrud {

    public void addEndereco(Endereco endereco) {
        String sql = "INSERT INTO Endereco (id_cidade, rua, numero) VALUES (?, ?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getIdCidade());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getNumero());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco getEndereco(int id) {
        String sql = "SELECT * FROM Endereco WHERE id = ?";
        Endereco endereco = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setIdCidade(rs.getInt("id_cidade"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    public List<Endereco> getAllEnderecos() {
        String sql = "SELECT * FROM Endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setIdCidade(rs.getInt("id_cidade"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                enderecos.add(endereco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }

    public void updateEndereco(Endereco endereco) {
        String sql = "UPDATE Endereco SET id_cidade = ?, rua = ?, numero = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getIdCidade());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getNumero());
            stmt.setInt(4, endereco.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEndereco(int id) {
        String sql = "DELETE FROM Endereco WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
