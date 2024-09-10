-- Create database
CREATE DATABASE Library;

-- Connect to the database
\c Library

-- Create parent tables
CREATE TABLE document (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    annee_publication INT NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE utilisateur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Create child tables for documents
CREATE TABLE livre (
    isbn VARCHAR(20) UNIQUE NOT NULL,
    nombre_pages INT NOT NULL,
    emprunteur_id INT,
    reservateur_id INT
) INHERITS (document);

CREATE TABLE magazine (
    numero INT NOT NULL
) INHERITS (document);

CREATE TABLE journal_scientifique (
    universite VARCHAR(255) NOT NULL
) INHERITS (document);

CREATE TABLE these_universitaire (
    universite VARCHAR(255) NOT NULL,
    domaine VARCHAR(255) NOT NULL
) INHERITS (document);

-- Create child tables for users
CREATE TABLE etudiant (
    niveau_etude VARCHAR(50) NOT NULL
) INHERITS (utilisateur);

CREATE TABLE professeur (
    universite VARCHAR(255) NOT NULL
) INHERITS (utilisateur);

-- Create additional tables
CREATE TABLE emprunt (
    id SERIAL PRIMARY KEY,
    document_id INT REFERENCES document(id),
    utilisateur_id INT REFERENCES utilisateur(id),
    date_emprunt DATE NOT NULL,
    date_retour_prevue DATE NOT NULL
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    document_id INT REFERENCES document(id),
    utilisateur_id INT REFERENCES utilisateur(id),
    date_reservation DATE NOT NULL
);
