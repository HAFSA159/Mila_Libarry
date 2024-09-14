package com.library.dao;

import com.library.model.JournalScientifique;
import com.library.model.Livre;
import com.library.model.Magazine;
import com.library.model.TheseUniversitaire;
import com.library.utilitaire.InputValidator;
import resources.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DocumentDAO {
    private static final Logger logger = Logger.getLogger(DocumentDAO.class.getName());

    //ADD methods

    public static void addBook(Livre livre) {
        String query = "INSERT INTO livre (titre, auteur, date_de_publication, nombre_de_pages, isbn) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn()); // L'index est corrigé ici (de 7 à 5)

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Livre ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre : " + e.getMessage());
        }
    }

    public static void addMagazine(Magazine magazine) {
        String query = "INSERT INTO magazine (titre, auteur, date_de_publication, nombre_de_pages, numero) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(magazine.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, magazine.getNumero());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Magazine ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du magazine : " + e.getMessage());
        }
    }

    public static void addScientificJournal(JournalScientifique journalScientifique) {
        String query = "INSERT INTO journalscientifique (titre, auteur, date_de_publication, nombre_de_pages, domaine_recherche) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, journalScientifique.getTitre());
            stmt.setString(2, journalScientifique.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(journalScientifique.getDatePublication()));
            stmt.setInt(4, journalScientifique.getNombreDePages());
            stmt.setString(5, journalScientifique.getDomaineRecherche());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Journal Scientifique ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du Journal Scientifique : " + e.getMessage());
        }
    }

    public static void addUniversityThesis(TheseUniversitaire theseUniversitaire) {
        String query = "INSERT INTO theseuniversitaire (titre, auteur, date_de_publication, nombre_de_pages, universite, domaine) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, theseUniversitaire.getTitre());
            stmt.setString(2, theseUniversitaire.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(theseUniversitaire.getDatePublication())); // Conversion de LocalDate à java.sql.Date
            stmt.setInt(4, theseUniversitaire.getNombreDePages());
            stmt.setString(5, theseUniversitaire.getUniversite());
            stmt.setString(6, theseUniversitaire.getDomaine());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thèse Universitaire ajoutée avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la thèse universitaire : " + e.getMessage());
        }
    }

    //UPDATE methods

    public static void updateLivre(Livre livre, int id) {
        String query = "UPDATE livre SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, isbn = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(livre.getDatePublication()));
            stmt.setInt(4, livre.getNombreDePages());
            stmt.setString(5, livre.getIsbn());

            stmt.setInt(6, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Livre modifié avec succès !");
            } else {
                System.out.println("Aucun livre trouvé avec l'ID spécifié.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du livre : " + e.getMessage());
        }
    }

    public static void updateMagazine(Magazine magazine) {
        String query = "UPDATE magazine SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, numero = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, magazine.getTitre());
            stmt.setString(2, magazine.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(magazine.getDatePublication()));
            stmt.setInt(4, magazine.getNombreDePages());
            stmt.setString(5, magazine.getNumero());
            stmt.setInt(6, magazine.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Magazine updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating Magazine: " + e.getMessage());
        }
    }

    public static void updateJournalScientifique(JournalScientifique journalScientifique) {
        String query = "UPDATE journal_scientifique SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, domaine_recherche = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, journalScientifique.getTitre());
            stmt.setString(2, journalScientifique.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(journalScientifique.getDatePublication()));
            stmt.setInt(4, journalScientifique.getNombreDePages());
            stmt.setString(5, journalScientifique.getDomaineRecherche());
            stmt.setInt(6, journalScientifique.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Journal Scientifique updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating Journal Scientifique: " + e.getMessage());
        }
    }

    public static void updateTheseUniversitaire(TheseUniversitaire theseUniversitaire) {
        String query = "UPDATE these_universitaire SET titre = ?, auteur = ?, date_de_publication = ?, nombre_de_pages = ?, universite = ?, domaine = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, theseUniversitaire.getTitre());
            stmt.setString(2, theseUniversitaire.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(theseUniversitaire.getDatePublication()));
            stmt.setInt(4, theseUniversitaire.getNombreDePages());
            stmt.setString(5, theseUniversitaire.getUniversite());
            stmt.setString(6, theseUniversitaire.getDomaine());
            stmt.setInt(7, theseUniversitaire.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Thèse Universitaire updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating Thèse Universitaire: " + e.getMessage());
        }
    }

    //DELETE methods

    public static void deleteDocument(int id, String type) {
        String query;

        switch (type.toLowerCase()) {
            case "livre":
                query = "DELETE FROM livre WHERE id = ?";
                break;
            case "magazine":
                query = "DELETE FROM magazine WHERE id = ?";
                break;
            case "journal scientifique":
                query = "DELETE FROM journalscientifique WHERE id = ?";
                break;
            case "these universitaire":
                query = "DELETE FROM theseuniversitaire WHERE id = ?";
                break;
            default:
                System.out.println("Type de document invalide.");
                return;
        }

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Document supprimé avec succès !");
            } else {
                System.out.println("Aucun document trouvé avec cet ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du document : " + e.getMessage());
        }
    }

    public static void searchDocument(String titre) {
        String[] types = {"livre", "magazine", "journalscientifique", "theseuniversitaire"};

        for (String type : types) {
            String query = "SELECT * FROM " + type + " WHERE titre LIKE ?";

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, "%" + titre + "%");
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // Adjust this based on your actual table schema
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Titre: " + rs.getString("titre"));
                    System.out.println("Auteur: " + rs.getString("auteur"));
                    System.out.println("Date de Publication: " + rs.getDate("date_de_publication"));
                    System.out.println("Nombre de Pages: " + rs.getInt("nombre_de_pages"));
                    if (type.equals("livre")) {
                        System.out.println("ISBN: " + rs.getString("isbn"));
                    } else if (type.equals("magazine")) {
                        System.out.println("Numéro: " + rs.getString("numero"));
                    } else if (type.equals("journalscientifique")) {
                        System.out.println("Domaine de Recherche: " + rs.getString("domaine_recherche"));
                    } else if (type.equals("theseuniversitaire")) {
                        System.out.println("Université: " + rs.getString("universite"));
                        System.out.println("Domaine: " + rs.getString("domaine"));
                    }
                    System.out.println();
                }

            } catch (SQLException e) {
                System.out.println("Erreur lors de la recherche du document : " + e.getMessage());
            }
        }
    }

    public static boolean borrowDocument(int id, String type) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.connect();

            String checkQuery = "SELECT etatDocument FROM " + type + " WHERE id = ? AND etatDocument = 'disponible'";
            ps = connection.prepareStatement(checkQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE " + type + " SET etatDocument = 'emprunté' WHERE id = ?";
                ps = connection.prepareStatement(updateQuery);
                ps.setInt(1, id);
                int rowsAffected = ps.executeUpdate();

                return rowsAffected > 0;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isAvailable(int documentId, String documentType) {
        Connection connection = DatabaseConnection.connect();
        String query = "SELECT reserve FROM " + documentType + " WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, documentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return !rs.getBoolean("reserve");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean reserveDocument(int documentId, String documentType, int userId) {
        Connection connection = DatabaseConnection.connect();
        String updateQuery = "UPDATE " + documentType + " SET reserve = ?, user_id_reserve = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setBoolean(1, true);
            ps.setInt(2, userId);
            ps.setInt(3, documentId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cancelReservation(int documentId) {
        Connection connection = DatabaseConnection.connect();
        String updateQuery = "UPDATE Document SET reserve = FALSE, user_id_reserve = NULL WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setInt(1, documentId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isReserved(int documentId) {
        Connection connection = DatabaseConnection.connect();
        String query = "SELECT reserve FROM document WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, documentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("reserve");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean returnDocument(int documentId) {
        Connection connection = DatabaseConnection.connect();

        // Check if the document is reserved
        String checkReservedQuery = "SELECT reserve, user_id_reserve FROM Document WHERE id = ?";
        try (PreparedStatement checkPs = connection.prepareStatement(checkReservedQuery)) {
            checkPs.setInt(1, documentId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                boolean isReserved = rs.getBoolean("reserve");
                int reservedBy = rs.getInt("user_id_reserve");

                // Update document status
                String updateQuery;
                if (isReserved) {
                    // If reserved, make it available and assign it to the reserved user
                    updateQuery = "UPDATE Document SET etatDocument = 'emprunté', reserve = FALSE, user_id_reserve = NULL WHERE id = ?";
                } else {
                    // If not reserved, just make it available
                    updateQuery = "UPDATE Document SET etatDocument = 'disponible' WHERE id = ?";
                }

                try (PreparedStatement updatePs = connection.prepareStatement(updateQuery)) {
                    updatePs.setInt(1, documentId);
                    int rowsAffected = updatePs.executeUpdate();

                    // If the document was reserved, handle the reservation
                    if (isReserved) {
                        // Optionally, update a records table or notify the user
                        System.out.println("Document was reserved by user ID: " + reservedBy);
                        // Notify reserved user or handle next steps for reservation
                    }

                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }







}
