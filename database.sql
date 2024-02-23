-- Active: 1708418992719@@127.0.0.1@3306
CREATE DATABASE exam_jpa;

USE exam_jpa;

CREATE TABLE hotel (
    id INT AUTO_INCREMENT PRIMARY KEY, nom VARCHAR(255), adresse VARCHAR(255), nombreDeChambres INT
);

CREATE TABLE service (
    id INT AUTO_INCREMENT PRIMARY KEY, piscine BOOLEAN, spa BOOLEAN, restaurant BOOLEAN, boisson BOOLEAN, hotel_id INT, FOREIGN KEY (hotel_id) REFERENCES hotel (id)
);

CREATE TABLE chambre (
    id INT AUTO_INCREMENT PRIMARY KEY, numero VARCHAR(50), prixParNuit DECIMAL(10, 2), type VARCHAR(255), hotel_id INT, FOREIGN KEY (hotel_id) REFERENCES hotel (id)
);

CREATE TABLE client (
    id INT AUTO_INCREMENT PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255), adresse VARCHAR(255), numeroDeTelephone VARCHAR(255)
);