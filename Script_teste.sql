select * from usuarios;
select * from herois;
select * from armas;
select * from batalhas;
select * from heroisbatalhas;

select a.id, a.nome as 'Arma', a.tipo, herois.nome as 'Herois'
from armas a 
inner join herois on a.heroiId = herois.id; 

select hb.id, h.nome as 'Heroi', b.nome as 'Batalha', b.descricao as 'Descricao'
from heroisbatalhas hb 
inner join herois h on hb.heroiId = h.id 
inner join batalhas b on hb.batalhaId = b.id;