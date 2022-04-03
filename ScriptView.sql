select * from herois h
join batalhas b on h.id = b.heroiid

create view batalhasherois
as select h.id, h.nome as heroinome, b.nome as batalhanome, b.descricao
from herois h
join batalhas b on h.id = b.heroiid

select * from batalhasherois