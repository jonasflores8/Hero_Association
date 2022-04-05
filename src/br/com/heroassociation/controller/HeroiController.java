package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.Heroi;
import br.com.heroassociation.model.dao.DaoHeroi;
import java.sql.SQLException;
import java.util.List;

public class HeroiController {

    DaoHeroi daoH = null;

    public HeroiController() throws SQLException, ClassNotFoundException {
        daoH = new DaoHeroi();
    }

    public Heroi Insert(Heroi heroi) {
        return daoH.Insert(heroi);
    }

    public Heroi Select(Heroi heroi) {
        return daoH.Select(heroi);
    }

    public Heroi Update(Heroi heroi) { return daoH.Update(heroi); }

    public Heroi Delete(Heroi heroi) { return daoH.Delete(heroi); }

    public List<Heroi> Listar (Heroi heroi) throws SQLException, ClassNotFoundException {
        return daoH.Listar(heroi);
    }

}
