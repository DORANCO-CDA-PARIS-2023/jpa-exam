DROP DATABASE IF EXISTS Hotel;
CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE Hotel (
    ID_Hotel INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Adresse VARCHAR(255),
    NombreChambreDispo INT
);

CREATE TABLE Chambre (
    ID_Chambre INT PRIMARY KEY AUTO_INCREMENT,
    Numero VARCHAR(50),
    Type VARCHAR(100),
    Prix DECIMAL(10, 2),
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);

CREATE TABLE Client (
    ID_Client INT PRIMARY KEY AUTO_INCREMENT,
    Prenom VARCHAR(100),
    Nom VARCHAR(100),
    Adresse VARCHAR(255),
    Telephone VARCHAR(20)
);

CREATE TABLE Employer (
    ID_Employe INT PRIMARY KEY AUTO_INCREMENT,
    Prenom VARCHAR(100),
    Nom VARCHAR(100),
    Poste VARCHAR(100),
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);

CREATE TABLE Reservation (
    ID_Reservation INT PRIMARY KEY AUTO_INCREMENT,
    ID_Client INT,
    ID_Chambre INT,
    Date_Fin DATE,
    Date_Debut DATE,
    FOREIGN KEY (ID_Client) REFERENCES Client(ID_Client),
    FOREIGN KEY (ID_Chambre) REFERENCES Chambre(ID_Chambre)
);

CREATE TABLE Service (
    ID_Service INT PRIMARY KEY AUTO_INCREMENT,
    Libelle VARCHAR(100),
    Description TEXT,
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);

INSERT INTO Hotel (Nom, Adresse, NombreChambreDispo) VALUES
('Hotel 1', 'Adresse 1', 2),
('Hotel 2', 'Adresse 2', 2),
('Hotel 3', 'Adresse 3', 2);

INSERT INTO Reservation (ID_Client, ID_Chambre, Date_Debut, Date_Fin) VALUES
(1, 1, '2024-01-01', '2024-01-15'),
(2, 3, '2024-02-02', '2024-02-15'),
(3, 5, '2024-03-03', '2024-03-15');
(4, 3, '2024-02-16', '2024-02-27');

INSERT INTO Service (Libelle, Description, ID_Hotel) VALUES
('Repas Inclus', 'Petit-déjeuner et déjeuner inclus', 1);
('Piscine', 'Piscine extérieure', 2),
('Spa', 'Spa & Jaccuzi', 3),

INSERT INTO Chambre (Numero, Type, Prix, ID_Hotel) VALUES
('01', 'Simple', 50.00, 1),
('02', 'Simple', 50.00, 3),
('03', 'Double',90.00, 1),
('04', 'Double', 90.00,2),
('05', 'Suite', 130.00, 3),
('06', 'Suite', 130.00, 1);

INSERT INTO Client (Prenom, Nom, Telephone, Adresse) VALUES
('Michele', 'Obama', '0101010101', 'Adresse 1'),
('Tony', 'Parker', '0202020202', 'Adresse 2'),
('Carl', 'Thomas', '0303030303' 'Adresse 3');
('Carl', 'Thomas', '040404040' 'Adresse 4');

INSERT INTO Employer (Prenom, Nom, Poste, ID_Hotel) VALUES
('Charles', 'Henry', 'Réceptionniste', 1),
('Jack', 'Petterson', 'Directeur', 3),
('Michael', 'Williams', 'Réceptionniste', 4);
('Sarah', 'Thomson', 'Femme de ménage', 2);

