package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.HeroiBatalha;
import br.com.heroassociation.model.dao.DaoHeroiBatalha;
import java.sql.SQLException;
import java.util.List;

public class HeroiBatalhaController {

    DaoHeroiBatalha daoHb = null;

    public HeroiBatalhaController() throws SQLException, ClassNotFoundException {
        daoHb = new DaoHeroiBatalha();
    }

    public HeroiBatalha Insert(HeroiBatalha heroiBatalha) {
        return daoHb.Insert(heroiBatalha);
    }

    public HeroiBatalha Select(HeroiBatalha heroiBatalha) {
        return daoHb.Select(heroiBatalha);
    }

    public HeroiBatalha Update(HeroiBatalha heroiBatalha) { return daoHb.Update(heroiBatalha); }

    public HeroiBatalha Delete(HeroiBatalha heroiBatalha) { return daoHb.Delete(heroiBatalha); }

    public List<HeroiBatalha> Listar (HeroiBatalha heroiBatalha) { return daoHb.Listar(heroiBatalha); }

}
