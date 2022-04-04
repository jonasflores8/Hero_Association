select hb.id, h.nome as 'Heroi', b.nome as 'batalha', b.descricao, b.duracao
from heroisbatalhas hb
inner join herois h on hb.heroiId = h.id 
inner join batalhas b on hb.batalhaId = b.id
where hb.id = 2;

select * from heroisbatalhas;

select * from batalhas;
select * from herois;