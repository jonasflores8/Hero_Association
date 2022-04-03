CREATE DATABASE teste;

use teste;

CREATE TABLE Usuarios (
    id int NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    CONSTRAINT PK_Usuarios PRIMARY KEY (id)
);

CREATE TABLE Herois (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    identidade VARCHAR(45) NOT NULL,
    CONSTRAINT PK_Herois PRIMARY KEY (id)
);

CREATE TABLE Armas (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    heroiId int NOT NULL,
    CONSTRAINT PK_Armas PRIMARY KEY (id),
    CONSTRAINT FK_Armas_Herois_heroiId FOREIGN KEY (heroiId) REFERENCES Herois (id) ON DELETE CASCADE
);

CREATE TABLE Batalhas (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    descricao VARCHAR(45),
    duracao float,
    heroiid int NOT NULL,
    CONSTRAINT PK_Batalhas PRIMARY KEY (id),
    CONSTRAINT FK_Batalhas_Herois_heroiId FOREIGN KEY (heroiId) REFERENCES Herois (id) ON DELETE CASCADE
);

INSERT INTO usuarios (login, senha, status, tipo) VALUES ('jonas', 'xxx', 'ativado', 'adm');

INSERT INTO herois (nome, identidade) VALUES ('Thor', 'Thor Odinson');
INSERT INTO herois (nome, identidade) VALUES ('Spiderman', 'Peter Parker');

INSERT INTO armas (nome, tipo, heroiId) VALUES ('Stormbreaker', 'Machado', '1');
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Mijolnir', 'Martelo', '1');

INSERT INTO batalhas (nome, descricao, duracao, heroiId) VALUES ('Thir vc Thanos', 'Ultima batalha no filme', 20, 1);

INSERT INTO armas (nome, tipo, heroiId) VALUES ('Lançadores de Teia', 'Lançador', '2');
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Cinto de Utilidades', 'Cinto', '2');
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Localizadores-Aranha', 'Localizadores', '2');
