-- ****************** HEROIS *********************
select * from herois

select h.id, h.nome, armas.nome
from herois h
inner join armas
on h.id = armas.heroiId
where h.id = 1

-- ****************** ARMAS *********************
select * from armas

select a.id, a.nome, herois.nome
from armas a
inner join herois
on a.heroiId = herois.id

select a.id, a.nome, herois.nome
from armas a
inner join herois
on a.heroiId = herois.id
where a.id = 2
