# Gestion de Bibliothèque Municipale - Brief 2

## Description du Projet

Le projet **Gestion de Bibliothèque Municipale** est une application Java permettant de gérer une bibliothèque publique. L'application permet de gérer l'inventaire des documents (livres, magazines, journaux scientifiques, thèses universitaires), ainsi que les opérations d'emprunt, de retour et de réservation. Elle suit une architecture en couches, avec PostgreSQL pour la persistance des données.

## Objectif Général de l'Application

L'objectif est de fournir un système de gestion de bibliothèque qui facilite la gestion des documents, des utilisateurs, des emprunts et des retours, avec une interface simple et efficace.

## Technologies Utilisées

- **Java 8** : Langage de programmation principal.
- **PostgreSQL** : Base de données relationnelle pour la gestion des documents et des utilisateurs.
- **Git** : Outil de gestion de version pour le code source.
- **JIRA** : Gestion des tâches et suivi du projet.

## Structure du Projet

- **Couche Présentation** : Interface utilisateur en console pour l'interaction avec l'application.
- **Couche Business** : Logique métier pour les emprunts, retours, réservations et gestion des utilisateurs.
- **Couche Persistance** : DAO pour l'accès aux données dans PostgreSQL.

## Description Brève de l'Architecture Adoptée

L'architecture en couches sépare les responsabilités en trois parties :
1. **Couche Présentation (Console)** : Interface pour que les utilisateurs interagissent avec l'application via la console.
2. **Couche Business** : Logique métier pour gérer les documents, les utilisateurs, et les opérations de la bibliothèque.
3. **Couche Persistance (DAO)** : Gère l'accès et les interactions avec la base de données PostgreSQL.

## Prérequis

- **Java 8** ou version ultérieure.
- **PostgreSQL** installé et configuré.
- **Git** pour cloner le projet.

## Étapes pour Configurer la Base de Données

1. Installez PostgreSQL et assurez-vous qu'il fonctionne correctement.
2. Créez une base de données nommée `bibliotheque`.
3. Mettez à jour les informations de connexion dans le fichier `application.properties` (ou dans le code source) avec vos identifiants PostgreSQL.
4. Exécutez les scripts SQL fournis pour créer les tables requises.

## Instructions d'Installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/JavaAura/Hafsa_Elmoatassim_Billah_S1_B2_Library_System_V2
   cd Gestion_dune_bibliotheque_2

## Améliorations Futures Possibles

- Intégration d'une **interface graphique (GUI)** pour une meilleure expérience utilisateur.
- Ajout d'un système de **notifications par e-mail** pour rappeler aux utilisateurs les dates de retour des documents empruntés.
- **Statistiques d'emprunt** pour suivre les tendances d'utilisation des documents.
- Prise en charge de **documents numériques** tels que les ebooks.

## Idées pour Étendre ou Améliorer le Projet

- Développer une **API REST** pour permettre une intégration avec des applications web ou mobiles.
- Ajout d'un module de **recommandation de documents** basé sur les emprunts passés des utilisateurs.
- Intégration de nouvelles fonctionnalités comme un **système de pénalités** pour les retours en retard.

## Auteur et Contact

- **Auteur** : Hafsa Elmoatassim Billah
- **Contact** : [hafsa.elmoatassim@gmail.com](mailto:hafsa.elmoatassim@gmail.com)