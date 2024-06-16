
package CRUD;

import Dominio.TelefoneUsuario;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneUsuarioCrud {
     public void addTelefone(TelefoneUsuario telefone) {
        String sql = "INSERT INTO Telefone_Usuario (numero) VALUES (?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, telefone.getNumero());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TelefoneUsuario getTelefone(int id) {
        String sql = "SELECT * FROM Telefone_Usuario WHERE id = ?";
        TelefoneUsuario telefone = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                telefone = new TelefoneUsuario();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return telefone;
    }

    public List<TelefoneUsuario> getAllTelefones() {
        String sql = "SELECT * FROM Telefone_Usuario";
        List<TelefoneUsuario> telefones = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TelefoneUsuario telefone = new TelefoneUsuario();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefones.add(telefone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return telefones;
    }

    public void updateTelefone(TelefoneUsuario telefone) {
        String sql = "UPDATE Telefone_Usuario SET numero = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, telefone.getNumero());
            stmt.setInt(2, telefone.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTelefone(int id) {
        String sql = "DELETE FROM Telefone_Usuario WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
