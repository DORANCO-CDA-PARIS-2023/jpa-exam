DROP DATABASE IF EXISTS GestionHotel;
CREATE DATABASE GestionHotel;

USE GestionHotel;

CREATE TABLE IF NOT EXISTS Hotel (
    ID_hotel INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    nombreTotalChambres INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Chambre (
    ID_chambre INT AUTO_INCREMENT PRIMARY KEY,
    numero_chambre INT NOT NULL,
    type VARCHAR(255) NOT NULL,
    prix_par_nuit DECIMAL(10, 2) NOT NULL,
    ID_hotel INT NOT NULL,
    FOREIGN KEY (ID_hotel) REFERENCES Hotel(ID_hotel)
);

CREATE TABLE IF NOT EXISTS Client (
    ID_client INT AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    numeroTel VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employe (
    ID_employe INT AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    poste VARCHAR(100) NOT NULL,
    ID_hotel INT NOT NULL,
    FOREIGN KEY (ID_hotel) REFERENCES Hotel(ID_hotel)
);

CREATE TABLE IF NOT EXISTS Reservation (
    ID_reservation INT AUTO_INCREMENT PRIMARY KEY,
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL,
    ID_client INT NOT NULL,
    ID_chambre INT NOT NULL,
    FOREIGN KEY (ID_client) REFERENCES Client(ID_client),
    FOREIGN KEY (ID_chambre) REFERENCES Chambre(ID_chambre)
);

CREATE TABLE IF NOT EXISTS Service (
    ID_service INT AUTO_INCREMENT PRIMARY KEY,
    nomService VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Service_Hotel (
    ID_service_hotel INT AUTO_INCREMENT PRIMARY KEY,
    ID_service INT NOT NULL,
    ID_hotel INT NOT NULL,
    FOREIGN KEY (ID_service) REFERENCES Service(ID_service),
    FOREIGN KEY (ID_hotel) REFERENCES Hotel(ID_hotel)
);