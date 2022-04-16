package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Batalha;
import br.com.heroassociation.model.bean.Heroi;
import br.com.heroassociation.model.bean.HeroiBatalha;
import br.com.heroassociation.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoHeroiBatalha {

    private final Connection con;

    public DaoHeroiBatalha() throws SQLException, ClassNotFoundException{
        this.con = new Conexao().getConnection();
    }

    public HeroiBatalha Insert(HeroiBatalha heroiBatalha) {
        try {
            String sql = "insert into HeroisBatalhas" + " (heroiId, batalhaId)" + " values (?,?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, heroiBatalha.getHeroiId());
            statement.setInt(2, heroiBatalha.getBatalhaId());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                heroiBatalha.setId(id);
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heroiBatalha;
    }

    public HeroiBatalha Select(HeroiBatalha HeroiBatalha) {
        try {
            String sql = "select hb.id, h.nome as 'Heroi', b.nome as 'Batalha', b.descricao as 'Descrção' " +
                    "from heroisbatalhas hb " +
                    "inner join herois h on hb.heroiId = h.id " +
                    "inner join batalhas b on hb.batalhaId = b.id " +
                    "where hb.id = ?";
            PreparedStatement statement = this.con.prepareStatement(sql);

            statement.setInt(1,HeroiBatalha.getId());

            ResultSet rs = statement.executeQuery();
            HeroiBatalha retorno = null;
            while (rs.next()) {
                retorno = new HeroiBatalha(
                        rs.getInt(1),
                        new Heroi(rs.getString(2)),
                        new Batalha(rs.getString(3), rs.getString(4)));
            }
            HeroiBatalha = retorno;
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return HeroiBatalha;
    }

    public HeroiBatalha Update(HeroiBatalha heroiBatalha) {
        try{
            String sql = "UPDATE HeroisBatalhas SET heroiId = ?, batalhaId = ? WHERE id = ?;";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, heroiBatalha.getHeroiId());
            statement.setInt(2, heroiBatalha.getBatalhaId());
            statement.setInt(3, heroiBatalha.getId());

            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heroiBatalha;
    }

    public HeroiBatalha Delete(HeroiBatalha HeroiBatalha) {
        try {
            String sql = "delete from HeroisBatalhas WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1,HeroiBatalha.getId());

            statement.execute();
            statement.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return HeroiBatalha;
    }

    public List<HeroiBatalha> Listar(HeroiBatalha heroiBatalha) {

        List<HeroiBatalha> heroisBatalhas = new ArrayList<>();

        try{
            String sql = "select hb.id, h.nome as 'Heroi', b.nome as 'Batalha', b.descricao as 'Descricao' " +
                    "from heroisbatalhas hb " +
                    "inner join herois h on hb.heroiId = h.id " +
                    "inner join batalhas b on hb.batalhaId = b.id";

            PreparedStatement statement = this.con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HeroiBatalha hb = new HeroiBatalha(
                        rs.getInt(1),
                        new Heroi(rs.getString(2)),
                        new Batalha(rs.getString(3), rs.getString(4)));

                heroisBatalhas.add(hb);
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return heroisBatalhas;
    }

}
