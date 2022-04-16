package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Batalha;
import br.com.heroassociation.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBatalha {

    private final Connection con;

    public DaoBatalha() throws SQLException, ClassNotFoundException{
        this.con = new Conexao().getConnection();
    }

    public Batalha Insert(Batalha batalha) {
        try {
            String sql = "insert into batalhas" + " (nome, descricao, duracao)" + " values (?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, batalha.getNome());
            statement.setString(2, batalha.getDescricao());
            statement.setFloat(3, batalha.getDuracao());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                batalha.setId(id);
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return batalha;
    }

    public Batalha Select(Batalha batalha) {
        try {
            String sql = "SELECT * FROM batalhas WHERE id = ?";
            PreparedStatement statement = this.con.prepareStatement(sql);

            statement.setInt(1,batalha.getId());

            ResultSet rs = statement.executeQuery();
            Batalha retorno = null;
            while (rs.next()) {
                retorno = new Batalha(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4));
            }
            batalha = retorno;
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return batalha;
    }

    public Batalha Update(Batalha batalha) {
        try{
            String sql = "UPDATE batalhas SET nome = ?, descricao = ?, " +
                    "duracao = ?  WHERE id = ?;";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1,batalha.getNome());
            statement.setString(2,batalha.getDescricao());
            statement.setFloat(3, batalha.getDuracao());
            statement.setInt(4, batalha.getId());

            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return batalha;
    }

    public Batalha Delete(Batalha batalha) {
        try {
            String sql = "delete from batalhas WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1,batalha.getId());

            statement.execute();
            statement.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return batalha;
    }

    public List<Batalha> Listar(Batalha batalha) {

        List<Batalha> batalhas = new ArrayList<>();

        try{
            String sql = "select * from batalhas";

            PreparedStatement statement = this.con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Batalha b = new Batalha(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4));

                batalhas.add(b);
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return batalhas;
    }

}