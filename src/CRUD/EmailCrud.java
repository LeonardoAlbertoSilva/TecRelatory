
package CRUD;

import Dominio.Email;
import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailCrud {

    public void addEmail(Email email) {
        String sql = "INSERT INTO Email (email) VALUES (?)";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Email getEmail(int id) {
        String sql = "SELECT * FROM Email WHERE id = ?";
        Email email = null;

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                email = new Email();
                email.setId(rs.getInt("id"));
                email.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }

    public List<Email> getAllEmails() {
        String sql = "SELECT * FROM Email";
        List<Email> emails = new ArrayList<>();

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Email email = new Email();
                email.setId(rs.getInt("id"));
                email.setEmail(rs.getString("email"));
                emails.add(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    public void updateEmail(Email email) {
        String sql = "UPDATE Email SET email = ? WHERE id = ?";

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
        String sql = "DELETE FROM Email WHERE id = ?";

        try (Connection conn = new ConnectFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
