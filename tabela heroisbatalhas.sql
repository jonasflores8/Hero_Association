CREATE TABLE heroapp . HeroisBatalhas (
	id int not null auto_increment,
    heroiId int NOT NULL,
    batalhaId int NOT NULL,
    CONSTRAINT PK_HeroisBatalhas PRIMARY KEY (id),
    CONSTRAINT FK_HeroisBatalhas_Herois_heroiId FOREIGN KEY (heroiId) REFERENCES Herois (id) ON DELETE CASCADE,
    CONSTRAINT FK_HeroisBatalhas_Batalhas_batalhaId FOREIGN KEY (batalhaId) REFERENCES Batalhas (id) ON DELETE CASCADE
);