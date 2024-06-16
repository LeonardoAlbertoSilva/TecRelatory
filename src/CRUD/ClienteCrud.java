
package CRUD;

import Dominio.Cliente;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCrud {

    public void addCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf, id_endereço, id_telefone, id_email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setInt(3, cliente.getIdEndereco());
            stmt.setInt(4, cliente.getIdTelefone());
            stmt.setInt(5, cliente.getIdEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente getCliente(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente cliente = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setIdEndereco(rs.getInt("id_endereço"));
                cliente.setIdTelefone(rs.getInt("id_telefone"));
                cliente.setIdEmail(rs.getInt("id_email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public List<Cliente> getAllClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setIdEndereco(rs.getInt("id_endereço"));
                cliente.setIdTelefone(rs.getInt("id_telefone"));
                cliente.setIdEmail(rs.getInt("id_email"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, cpf = ?, id_endereço = ?, id_telefone = ?, id_email = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setInt(3, cliente.getIdEndereco());
            stmt.setInt(4, cliente.getIdTelefone());
            stmt.setInt(5, cliente.getIdEmail());
            stmt.setInt(6, cliente.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}