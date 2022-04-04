select hb.heroiId, h.nome, b.nome, b.descricao
from heroisbatalhas hb
inner join herois h on hb.heroiId = h.id 
inner join batalhas b on hb.batalhaId = b.id
where hb.id = 1