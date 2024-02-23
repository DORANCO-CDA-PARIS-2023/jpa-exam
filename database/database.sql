DROP DATABASE IF EXISTS Hotel;
CREATE DATABASE Hotel;

USE Hotel;

-- Table Hotel
CREATE TABLE Hotel (
    ID_Hotel INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Adresse VARCHAR(255),
    Nb_Chambre_Dispo INT
);

-- Table Chambre
CREATE TABLE Chambre (
    ID_Chambre INT PRIMARY KEY AUTO_INCREMENT,
    Numero VARCHAR(50),
    Type VARCHAR(100),
    Prix DECIMAL(10, 2),
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);

-- Table Client
CREATE TABLE Client (
    ID_Client INT PRIMARY KEY AUTO_INCREMENT,
    Prenom VARCHAR(100),
    Nom VARCHAR(100),
    Adresse VARCHAR(255),
    Telephone VARCHAR(20)
);

-- Table Employer
CREATE TABLE Employer (
    ID_Employe INT PRIMARY KEY AUTO_INCREMENT,
    Prenom VARCHAR(100),
    Nom VARCHAR(100),
    Poste VARCHAR(100),
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);

-- Table Reservation
CREATE TABLE Reservation (
    ID_Reservation INT PRIMARY KEY AUTO_INCREMENT,
    ID_Client INT,
    ID_Chambre INT,
    Date_Debut DATE,
    Date_Fin DATE,
    FOREIGN KEY (ID_Client) REFERENCES Client(ID_Client),
    FOREIGN KEY (ID_Chambre) REFERENCES Chambre(ID_Chambre)
);

-- Table Service
CREATE TABLE Service (
    ID_Service INT PRIMARY KEY AUTO_INCREMENT,
    Libelle VARCHAR(100),
    Description TEXT,
    ID_Hotel INT,
    FOREIGN KEY (ID_Hotel) REFERENCES Hotel(ID_Hotel)
);


-- Ajout d'éléments dans la table Hotel
INSERT INTO Hotel (Nom, Adresse, Nb_Chambre_Dispo) VALUES
('Hotel A', 'Adresse A', 2),
('Hotel B', 'Adresse B', 2),
('Hotel C', 'Adresse C', 2);

-- Ajout d'éléments dans la table Chambre
INSERT INTO Chambre (Numero, Type, Prix, ID_Hotel) VALUES
('101', 'Simple', 50.00, 1),
('102', 'Double', 75.00, 1),
('201', 'Simple', 60.00, 2),
('202', 'Double', 90.00, 2),
('301', 'Suite', 150.00, 3),
('302', 'Suite', 150.00, 3);

INSERT INTO Client (Prenom, Nom, Adresse, Telephone) VALUES
('John', 'Smith', 'Adresse 1', '0645789875'),
('Jane', 'Smith', 'Adresse 2', '0635348795'),
('François', 'Martin', 'Adresse 3', '0685754869');

INSERT INTO Employer (Prenom, Nom, Poste, ID_Hotel) VALUES
('Mike', 'Tyson', 'Réceptionniste', 1),
('Emma', 'Johnson', 'Gérant', 2),
('Michael', 'Williams', 'Concierge', 3);

INSERT INTO Reservation (ID_Client, ID_Chambre, Date_Debut, Date_Fin) VALUES
(1, 1, '2024-03-01', '2024-03-05'),
(2, 3, '2024-03-10', '2024-03-15'),
(3, 5, '2024-04-01', '2024-04-05');

INSERT INTO Service (Libelle, Description, ID_Hotel) VALUES
('Piscine', 'Piscine intérieure.', 1),
('Spa', 'Offre des services de spa et des soin.', 2),
('Restaurant', 'Restaurant ouvert pour le petit déjeuner, le déjeuner et le dîner.', 3);
