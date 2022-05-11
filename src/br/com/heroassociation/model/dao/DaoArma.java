package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Arma;
import br.com.heroassociation.model.bean.Heroi;
import br.com.heroassociation.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            return null;
        }
        return arma;
    }

    public Arma Select(Arma arma) {
        try {
            String sql = "select a.id, a.nome, a.tipo, h.nome " +
                    "from armas a " +
                    "inner join herois h " +
                    "on a.heroiId = h.id " +
                    "where a.id = ? ";
            PreparedStatement statement = this.con.prepareStatement(sql);

            statement.setString(1, String.valueOf(arma.getId()));

            ResultSet rs = statement.executeQuery();
            Arma retorno = null;
            while (rs.next()) {
                retorno = new Arma(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Heroi(rs.getString(4)));
            }
            arma = retorno;
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
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
            statement.setString(4, String.valueOf(arma.getId()));

            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
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
            return null;
        }
        return arma;
    }

    public List<Arma> Listar(Arma arma) {

        List<Arma> armas = new ArrayList<>();

        try{
            String sql = "select a.id, a.nome as 'Arma', a.tipo, herois.nome as 'Herois' " +
                    "from armas a " +
                    "inner join herois on a.heroiId = herois.id ";

            PreparedStatement statement = this.con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Arma a = new Arma(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Heroi(rs.getString(4)));

                armas.add(a);
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return armas;
    }

}