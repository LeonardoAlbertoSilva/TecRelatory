
package CRUD;

import Dominio.EmailUsuario;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailUsuarioCrud {
        public void addEmail(EmailUsuario email) {
        String sql = "INSERT INTO Email_Usuario (email) VALUES (?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmailUsuario getEmail(int id) {
        String sql = "SELECT * FROM Email_Usuario WHERE id = ?";
        EmailUsuario email = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                email = new EmailUsuario();
                email.setId(rs.getInt("id"));
                email.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }

    public List<EmailUsuario> getAllEmails() {
        String sql = "SELECT * FROM Email_Usuario Email";
        List<EmailUsuario> emails = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EmailUsuario email = new EmailUsuario();
                email.setId(rs.getInt("id"));
                email.setEmail(rs.getString("email"));
                emails.add(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    public void updateEmail(EmailUsuario email) {
        String sql = "UPDATE Email_Usuario SET email = ? WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email.getEmail());
            stmt.setInt(2, email.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmail(int id) {
        String sql = "DELETE FROM Email_Usuario WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
