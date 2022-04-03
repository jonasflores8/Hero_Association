package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.Arma;
import br.com.heroassociation.model.dao.DaoArma;
import java.sql.SQLException;

public class ArmaController {

    DaoArma daoA = null;

    public ArmaController() throws SQLException, ClassNotFoundException {
        daoA = new DaoArma();
    }

    public Arma Insert(Arma arma) {
        return daoA.Insert(arma);
    }

    public Arma Select(Arma arma) {
        return daoA.Select(arma);
    }

    public Arma Update(Arma arma) { return daoA.Update(arma); }

    public Arma Delete(Arma arma) { return daoA.Delete(arma); }

}
