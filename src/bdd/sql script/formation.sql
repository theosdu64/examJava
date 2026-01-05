
USE formation;

CREATE TABLE Formation (
    idFormation BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    dureeJours INT NOT NULL,
    typeFormation VARCHAR(20) NOT NULL CHECK (typeFormation IN ('présentiel', 'distanciel')),
    prix DOUBLE NOT NULL CHECK (prix >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Utilisateur (
    idUtilisateur BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Client (
    idClient BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Commande (
    idCommande BIGINT AUTO_INCREMENT PRIMARY KEY,
    dateCommande DATE NOT NULL,
    statut VARCHAR(20) NOT NULL DEFAULT 'EN_ATTENTE',
    montantTotal DOUBLE NOT NULL DEFAULT 0,
    idUtilisateur BIGINT NOT NULL,
    idClient BIGINT NOT NULL,
    FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur),
    FOREIGN KEY (idClient) REFERENCES Client(idClient)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ArticleCommande (
    idLigne BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantite INT NOT NULL CHECK (quantite > 0),
    prixUnitaire DOUBLE NOT NULL CHECK (prixUnitaire >= 0),
    idCommande BIGINT NOT NULL,
    idFormation BIGINT NOT NULL,
    FOREIGN KEY (idCommande) REFERENCES Commande(idCommande) ON DELETE CASCADE,
    FOREIGN KEY (idFormation) REFERENCES Formation(idFormation)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO Formation (nom, description, dureeJours, typeFormation, prix) VALUES
('Java SE 8 : Syntaxe & POO', 'Maîtriser les fondamentaux de Java : syntaxe, POO, exceptions, collections, fichiers et JDBC', 20, 'présentiel', 2000.00),
('Java Avancé', 'Approfondir Java : threads, design patterns, tests unitaires et performance', 20, 'distanciel', 2200.00),
('Spring Framework', 'Développer des applications d''entreprise avec Spring Core, MVC et Security', 20, 'présentiel', 2500.00),
('PHP Frameworks', 'Maîtriser Symfony et Laravel pour créer des applications web modernes', 15, 'distanciel', 1800.00),
('C#', 'Apprendre C# et .NET pour développer des applications Windows et web', 20, 'présentiel', 2100.00),
('Python', 'Découvrir Python : syntaxe, structures de données, modules et frameworks', 15, 'distanciel', 1900.00),
('React', 'Créer des interfaces utilisateur dynamiques avec React et Redux', 10, 'présentiel', 1500.00),
('Angular', 'Développer des applications web avec Angular et TypeScript', 10, 'distanciel', 1600.00),
('Vue.js', 'Construire des interfaces réactives avec Vue.js et son écosystème', 8, 'présentiel', 1200.00),
('Node.js', 'Développer des applications backend avec Node.js et Express', 12, 'distanciel', 1700.00);

INSERT INTO Utilisateur (email, password) VALUES
('pierre.martin@example.com', 'password123'),
('marie.durand@example.com', 'password123'),
('jean.bernard@example.com', 'password123'),
('sophie.petit@example.com', 'password123'),
('luc.moreau@example.com', 'password123');

INSERT INTO Client (nom, prenom, email, adresse, telephone) VALUES
('Entreprise TechCorp', 'Service RH', 'rh@techcorp.fr', '15 rue de la Tech, 75001 Paris', '0145678901'),
('Startup InnovIA', 'Directeur Formation', 'formation@innovia.fr', '22 avenue Innovation, 69002 Lyon', '0478123456'),
('Société DataPro', 'Responsable Compétences', 'competences@datapro.fr', '8 boulevard Data, 33000 Bordeaux', '0556789012'),
('Groupe WebFactory', 'Chef de Projet', 'projet@webfactory.fr', '45 rue du Web, 59000 Lille', '0320456789'),
('Entreprise CloudSys', 'Manager IT', 'it@cloudsys.fr', '12 place Cloud, 31000 Toulouse', '0561234567');

INSERT INTO Commande (dateCommande, statut, montantTotal, idUtilisateur, idClient) VALUES
('2025-12-15', 'VALIDEE', 4000.00, 1, 1),
('2025-12-20', 'EN_ATTENTE', 2500.00, 2, 2),
('2026-01-03', 'VALIDEE', 3700.00, 3, 3),
('2026-01-04', 'EN_COURS', 1500.00, 1, 4),
('2026-01-05', 'EN_ATTENTE', 3200.00, 4, 5);


INSERT INTO ArticleCommande (quantite, prixUnitaire, idCommande, idFormation) VALUES
(1, 2000.00, 1, 1),
(1, 2000.00, 1, 2);

INSERT INTO ArticleCommande (quantite, prixUnitaire, idCommande, idFormation) VALUES
(1, 2500.00, 2, 3);


INSERT INTO ArticleCommande (quantite, prixUnitaire, idCommande, idFormation) VALUES
(1, 1900.00, 3, 6),
(1, 1800.00, 3, 4);

INSERT INTO ArticleCommande (quantite, prixUnitaire, idCommande, idFormation) VALUES
(1, 1500.00, 4, 7);

INSERT INTO ArticleCommande (quantite, prixUnitaire, idCommande, idFormation) VALUES
(2, 1600.00, 5, 8);
