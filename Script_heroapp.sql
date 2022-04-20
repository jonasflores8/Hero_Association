CREATE DATABASE HeroApp;

USE HeroApp;

CREATE TABLE Usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    STATUS VARCHAR(20) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    CONSTRAINT PK_Usuarios PRIMARY KEY (id)
);

CREATE TABLE Herois (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    identidade VARCHAR(50),
    CONSTRAINT PK_Herois PRIMARY KEY (id)
);

CREATE TABLE Armas (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(50),
    heroiId INT NOT NULL,
    CONSTRAINT PK_Armas PRIMARY KEY (id),
    CONSTRAINT FK_Armas_Herois_heroiId FOREIGN KEY (heroiId) REFERENCES Herois (id) ON DELETE CASCADE
);

CREATE TABLE Batalhas (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(200),
    duracao float,
    CONSTRAINT PK_Batalhas PRIMARY KEY (id)
);

CREATE TABLE HeroisBatalhas (
	id INT NOT NULL AUTO_INCREMENT,
    heroiId INT NOT NULL,
    batalhaId INT NOT NULL,
    CONSTRAINT PK_HeroisBatalhas PRIMARY KEY (id),
    CONSTRAINT FK_HeroisBatalhas_Herois_heroiId FOREIGN KEY (heroiId) REFERENCES Herois (id) ON DELETE CASCADE,
    CONSTRAINT FK_HeroisBatalhas_Batalhas_batalhaId FOREIGN KEY (batalhaId) REFERENCES Batalhas (id) ON DELETE CASCADE
);

INSERT INTO usuarios (login, senha, status, tipo) VALUES ('jonas', 'xxx', '1', 'adm');
INSERT INTO usuarios (login, senha, status, tipo) VALUES ('sara', '1234', '1', 'visitante');

INSERT INTO herois (nome, identidade) VALUES ('Thor', 'sem');
INSERT INTO herois (nome, identidade) VALUES ('Batman', 'Bruce Wayne');
INSERT INTO herois (nome, identidade) VALUES ('Spiderman', 'Peter Parker');
INSERT INTO herois (nome, identidade) VALUES ('Superman', 'Clark Kent');

INSERT INTO armas (nome, tipo, heroiId) VALUES ('Stormbreaker', 'Machado', 1);
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Mijolnir', 'Martelo', 1);
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Lançador de teia', 'Lançador', 3);
INSERT INTO armas (nome, tipo, heroiId) VALUES ('Cinto de utilidades', 'Cinto', 2);

INSERT INTO batalhas (nome, descricao, duracao) VALUES ('Ultimato', 'Thor vs Thanos', 30);
INSERT INTO batalhas (nome, descricao, duracao) VALUES ('Ultimato', 'Spiderman vs Thanos', 30);
INSERT INTO batalhas (nome, descricao, duracao) VALUES ('Liga da Justiça', 'Batman vs Superman', 10);

INSERT INTO heroisbatalhas (heroiId, batalhaId) VALUES (1, 1);
INSERT INTO heroisbatalhas (heroiId, batalhaId) VALUES (3, 2);
INSERT INTO heroisbatalhas (heroiId, batalhaId) VALUES (2, 3);
INSERT INTO heroisbatalhas (heroiId, batalhaId) VALUES (4, 3);



