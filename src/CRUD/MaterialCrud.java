
package CRUD;

import Dominio.Material;
import connect.ConnectFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialCrud {
    
    public void create(Material material) throws SQLException {
        String sql = "INSERT INTO Material (descricao, quantidade, valor) VALUES (?, ?, ?)";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (conn != null) {
                stmt.setString(1, material.getDescricao());
                stmt.setDouble(2, material.getQuantidade());
                stmt.setDouble(3, material.getValor());
                stmt.executeUpdate();
            } else {
                throw new SQLException("Erro ao conectar ao banco de dados.");
            }
        }
    }
    
    public Material read(int id) throws SQLException {
        String sql = "SELECT * FROM Material WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("id"));
                material.setDescricao(rs.getString("descricao"));
                material.setQuantidade(rs.getDouble("quantidade"));
                material.setValor(rs.getDouble("valor"));
                return material;
            }
        }
        return null;
    }

    public List<Material> readAll() throws SQLException {
        String sql = "SELECT * FROM Material";
        List<Material> materials = new ArrayList<>();
        try (Connection conn = new ConnectFactory().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("id"));
                material.setDescricao(rs.getString("descricao"));
                material.setQuantidade(rs.getDouble("quantidade"));
                material.setValor(rs.getDouble("valor"));
                materials.add(material);
            }
        }
        return materials;
    }

    public void update(Material material) throws SQLException {
        String sql = "UPDATE Material SET descricao = ?, quantidade = ?, valor = ? WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getDescricao());
            stmt.setDouble(2, material.getQuantidade());
            stmt.setDouble(3, material.getValor());
            stmt.setInt(4, material.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Material WHERE id = ?";
        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
