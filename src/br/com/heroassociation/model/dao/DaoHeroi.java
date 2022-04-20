package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Heroi;
import br.com.heroassociation.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoHeroi {

    private final Connection con;

    public DaoHeroi() throws SQLException, ClassNotFoundException{
        this.con = new Conexao().getConnection();
    }

    public Heroi Insert(Heroi heroi) {
        try {
            String sql = "INSERT INTO herois" + " (nome, identidade)" + " values (?,?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,heroi.getNome());
            statement.setString(2,heroi.getIdentidade());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                heroi.setId(id);
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return heroi;
    }

    public Heroi Select(Heroi heroi) {
        try {
            String sql = "SELECT * FROM herois WHERE id = ?";

            PreparedStatement statement = this.con.prepareStatement(sql);

            statement.setInt(1,heroi.getId());

            ResultSet rs = statement.executeQuery();
            Heroi retorno = null;
            while (rs.next()) {
                retorno = new Heroi(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            statement.close();
            heroi = retorno;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return heroi;
    }

    public Heroi Update(Heroi heroi) {
        try{
            String sql = "UPDATE herois SET nome = ?, identidade = ? WHERE id = ?;";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1,heroi.getNome());
            statement.setString(2,heroi.getIdentidade());
            statement.setInt(3, heroi.getId());

            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return heroi;
    }

    public Heroi Delete(Heroi heroi) {
        try {
            String sql = "delete from herois WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1,heroi.getId());

            statement.execute();
            statement.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return heroi;
    }

    public List<Heroi> Listar(Heroi heroi) {

        List<Heroi> herois = new ArrayList<>();

        try {
            String sql = "select * from herois";

            PreparedStatement statement = this.con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Heroi h = new Heroi(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));

                herois.add(h);
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return herois;
    }

}
