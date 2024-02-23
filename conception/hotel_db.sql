CREATE TABLE Client (
    id INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255)
);

CREATE TABLE Chambre (
    id INT PRIMARY KEY,
    numero VARCHAR(255),
    type VARCHAR(255),
    prix DOUBLE,
    disponibilite BOOLEAN
);

CREATE TABLE Employe (
    id INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    poste VARCHAR(255)
);

CREATE TABLE Reservation (
    id INT PRIMARY KEY,
    date_debut_reservation DATE,
    date_fin_reservation DATE,
    id_chambre INT,
    id_client INT,
    FOREIGN KEY (id_chambre) REFERENCES Chambre(id),
    FOREIGN KEY (id_client) REFERENCES Client(id)
);

CREATE TABLE Service (
    id INT PRIMARY KEY,
    nom VARCHAR(255),
    description TEXT,
    prix DOUBLE
);

CREATE TABLE Reservation_Service (
    id_reservation INT,
    id_service INT,
    PRIMARY KEY (id_reservation, id_service),
    FOREIGN KEY (id_reservation) REFERENCES Reservation(id),
    FOREIGN KEY (id_service) REFERENCES Service(id)
);

CREATE TABLE Gestion_Chambre (
    id_emplye INT,
    id_chambre INT,
    PRIMARY KEY (id_emplye, id_chambre),
    FOREIGN KEY (id_emplye) REFERENCES Employe(id),
    FOREIGN KEY (id_chambre) REFERENCES Chambre(id)
);
