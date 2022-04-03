CREATE DATABASE heroapp;

use heroapp;

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
    CONSTRAINT PK_Batalhas PRIMARY KEY (id)
);

INSERT INTO usuarios (login, senha, status, tipo) VALUES ('jonas', 'xxx', 'ativado', 'adm');