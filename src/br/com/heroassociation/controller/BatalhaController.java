package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.Batalha;
import br.com.heroassociation.model.dao.DaoBatalha;
import java.sql.SQLException;
import java.util.List;

public class BatalhaController {

    DaoBatalha daoB = null;

    public BatalhaController() throws SQLException, ClassNotFoundException {
        daoB = new DaoBatalha();
    }

    public Batalha Insert(Batalha batalha) {
        return daoB.Insert(batalha);
    }

    public Batalha Select(Batalha batalha) {
        return daoB.Select(batalha);
    }

    public Batalha Update(Batalha batalha) { return daoB.Update(batalha); }

    public Batalha Delete(Batalha batalha) { return daoB.Delete(batalha); }

    public List<Batalha> Listar (Batalha batalha) throws SQLException, ClassNotFoundException {
        return daoB.Listar(batalha);
    }

}
