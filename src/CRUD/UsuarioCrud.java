
package CRUD;

import Dominio.Usuario;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCrud {
    
    public void addUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, cpf, id_telefone, id_email, login, senha) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setInt(3, usuario.getIdTelefone());
            stmt.setInt(4, usuario.getIdEmail());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuario(int id) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        Usuario usuario = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getInt("id_telefone"),
                    rs.getInt("id_email"),
                    rs.getString("login"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
        public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setIdTelefone(resultSet.getInt("id_telefone"));
                usuario.setIdEmail(resultSet.getInt("id_email"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, cpf = ?, id_telefone = ?, id_email = ?, login = ?, senha = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setInt(3, usuario.getIdTelefone());
            stmt.setInt(4, usuario.getIdEmail());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getSenha());
            stmt.setInt(7, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}