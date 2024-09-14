CREATE TABLE Document (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255),
    date_de_publication DATE,
    nombre_de_pages INT,
    etatDocument VARCHAR(50) DEFAULT 'disponible',
    reserve BOOLEAN DEFAULT FALSE,
    user_id_reserve INT
);


CREATE TABLE JournalScientifique (
    domaine_recherche VARCHAR(255) NOT NULL
) INHERITS (Document);


CREATE TABLE TheseUniversitaire (
    universite VARCHAR(255) NOT NULL,
    domaine VARCHAR(255) NOT NULL
) INHERITS (Document);


CREATE TABLE Livre (
    isbn VARCHAR(13) UNIQUE NOT NULL
) INHERITS (Document);


CREATE TABLE Magazine (
    numero VARCHAR(10) UNIQUE NOT NULL
) INHERITS (Document);


CREATE TABLE Utilisateur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Etudiant (
    matricule VARCHAR(20) UNIQUE NOT NULL
) INHERITS (Utilisateur);


CREATE TABLE Professeur (
    departement VARCHAR(255)
) INHERITS (Utilisateur);