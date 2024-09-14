package com.library.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Utilisateur;
import com.library.model.Etudiant;
import com.library.model.Professeur;
import resources.DatabaseConnection;

public class UtilisateurDAO {

    public boolean createUtilisateur(Utilisateur utilisateur) {
        Connection connection = null;
        PreparedStatement ps = null;
        String sql;

        try {
            connection = DatabaseConnection.connect();
            if (utilisateur instanceof Etudiant) {
                sql = "INSERT INTO Etudiant (nom, prenom, matricule) VALUES (?, ?, ?)";
                ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, utilisateur.getNom());
                ps.setString(2, utilisateur.getPrenom());
                ps.setString(3, ((Etudiant) utilisateur).getMatricule());
            } else if (utilisateur instanceof Professeur) {
                sql = "INSERT INTO Professeur (nom, prenom, departement) VALUES (?, ?, ?)";
                ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, utilisateur.getNom());
                ps.setString(2, utilisateur.getPrenom());
                ps.setString(3, ((Professeur) utilisateur).getDepartement());
            } else {
                throw new SQLException("Unsupported user type: " + utilisateur.getClass().getSimpleName());
            }

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    utilisateur.setId(generatedKeys.getInt(1)); // Set generated ID to the Utilisateur object
                }
                return true;
            }
            return false;

        } catch (SQLException e) {
            // Replace with proper logging in production
            e.printStackTrace();
            return false;
        } finally {
            closeResources(ps, connection);
        }
    }

    public Utilisateur getUtilisateurById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.connect();
            String sql = "SELECT * FROM Utilisateur WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return extractUtilisateurFromResultSet(rs);
            }
        } catch (SQLException e) {
            // Replace with proper logging in production
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, connection);
        }
        return null;
    }

    public boolean updateUtilisateur(Utilisateur utilisateur) {
        Connection connection = null;
        PreparedStatement ps = null;
        String sql;

        try {
            connection = DatabaseConnection.connect();
            if (utilisateur instanceof Etudiant) {
                sql = "UPDATE Etudiant SET nom = ?, prenom = ?, matricule = ? WHERE id = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, utilisateur.getNom());
                ps.setString(2, utilisateur.getPrenom());
                ps.setString(3, ((Etudiant) utilisateur).getMatricule());
            } else if (utilisateur instanceof Professeur) {
                sql = "UPDATE Professeur SET nom = ?, prenom = ?, departement = ? WHERE id = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, utilisateur.getNom());
                ps.setString(2, utilisateur.getPrenom());
                ps.setString(3, ((Professeur) utilisateur).getDepartement());
            } else {
                throw new SQLException("Unsupported user type: " + utilisateur.getClass().getSimpleName());
            }
            ps.setInt(4, utilisateur.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Replace with proper logging in production
            e.printStackTrace();
            return false;
        } finally {
            closeResources(ps, connection);
        }
    }

    public boolean deleteUtilisateur(int id) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DatabaseConnection.connect();
            String sql = "DELETE FROM Utilisateur WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Replace with proper logging in production
            e.printStackTrace();
            return false;
        } finally {
            closeResources(ps, connection);
        }
    }

    public List<Utilisateur> getAllUtilisateurs() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Utilisateur> utilisateurs = new ArrayList<>();

        try {
            connection = DatabaseConnection.connect();
            String sql = "SELECT * FROM Utilisateur";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Utilisateur utilisateur = extractUtilisateurFromResultSet(rs);
                utilisateurs.add(utilisateur);
            }

        } catch (SQLException e) {
            // Replace with proper logging in production
            e.printStackTrace();
        } finally {
            closeResources(rs, ps, connection);
        }
        return utilisateurs;
    }

    private Utilisateur extractUtilisateurFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");

        // Determine the user type based on the table
        // Assuming 'type' or equivalent column is in 'Utilisateur' or another means to differentiate
        // Add additional logic if needed

        // You can use `getTableNameFromId` or similar approach to identify the table if you have such a setup
        String sql = "SELECT * FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = rs.getStatement().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet etudiantRs = ps.executeQuery()) {
                if (etudiantRs.next()) {
                    return new Etudiant(id, nom, prenom, etudiantRs.getString("matricule"));
                }
            }
        }

        sql = "SELECT * FROM Professeur WHERE id = ?";
        try (PreparedStatement ps = rs.getStatement().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet professeurRs = ps.executeQuery()) {
                if (professeurRs.next()) {
                    return new Professeur(id, nom, prenom, professeurRs.getString("departement"));
                }
            }
        }

        throw new SQLException("Unknown user type for ID: " + id);
    }

    private void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    // Replace with proper logging in production
                    e.printStackTrace();
                }
            }
        }
    }
}
