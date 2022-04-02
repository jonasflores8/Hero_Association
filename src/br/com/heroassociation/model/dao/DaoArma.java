package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Arma;
import br.com.heroassociation.model.bean.Heroi;
import br.com.heroassociation.util.Conexao;
import java.sql.*;

public class DaoArma {

    private final Connection con;

    public DaoArma() throws SQLException, ClassNotFoundException{
        this.con = new Conexao().getConnection();
    }

    public Arma Insert(Arma arma) {
        try {
            String sql = "insert into armas" + " (nome, tipo, heroiId)" + " values (?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, String.valueOf(arma.getNome()));
            statement.setString(2, String.valueOf(arma.getTipo()));
            statement.setInt(3, Integer.parseInt(String.valueOf(arma.getHeroiId())));

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                arma.setId(id);
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arma;
    }

    public Arma Select(Arma arma) {
        try {
            String sql = "select a.id, a.nome, a.tipo, herois.nome, herois.id " +
                    "from armas a " +
                    "inner join herois " +
                    "on a.heroiId = herois.id " +
                    "where a.id = ?";
            PreparedStatement statement = this.con.prepareStatement(sql);

            statement.setInt(1,arma.getId());

            ResultSet rs = statement.executeQuery();
            Arma retorno = null;
            while (rs.next()) {
                retorno = new Arma(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Heroi(rs.getString(4), rs.getInt(5)));
            }
            arma = retorno;
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arma;
    }

    public Arma Update(Arma arma) {
        try{
            String sql = "UPDATE armas SET nome = ?, tipo = ?, heroiId = ? WHERE id = ?;";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1,arma.getNome());
            statement.setString(2,arma.getTipo());
            statement.setInt(3, arma.getHeroiId());
            statement.setInt(4, arma.getId());

            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arma;
    }

    public Arma Delete(Arma arma) {
        try {
            String sql = "delete from armas WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1,arma.getId());

            statement.execute();
            statement.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arma;
    }

}