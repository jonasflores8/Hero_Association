package br.com.heroassociation.model.dao;

import br.com.heroassociation.model.bean.Usuario;
import br.com.heroassociation.util.Conexao;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    private final Connection con;

    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.con = new Conexao().getConnection();
    }

    public Usuario Insert(Usuario usu) {
        try {
            String sql = "insert into usuarios" + " (login, senha, status, tipo)" + " values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,usu.getLogin());
            stmt.setString(2,usu.getSenha());
            stmt.setString(3,usu.getStatus());
            stmt.setString(4,usu.getTipo());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                usu.setId(id);
            }
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usu;
    }

    public Usuario Select(Usuario usu) {
        try {
            String sql = "select * from usuarios WHERE id = ?";

            PreparedStatement stmt = this.con.prepareStatement(sql);

            stmt.setInt(1,usu.getId());

            ResultSet rs = stmt.executeQuery();
            Usuario retorno = null;
            while (rs.next()) {

                retorno = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            stmt.close();
            usu = retorno;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usu;
    }

    public Usuario Update(Usuario usu) {
        try {
            String sql = "UPDATE usuarios SET login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,usu.getLogin());
            stmt.setString(2,usu.getSenha());
            stmt.setString(3,usu.getStatus());
            stmt.setString(4,usu.getTipo());
            stmt.setInt(5,usu.getId());

            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usu;
    }

    public Usuario Delete(Usuario usu) {
        try {
            String sql = "delete from usuarios WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,usu.getId());

            stmt.execute();
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usu;
    }

    public List<Usuario> Listar(Usuario usuEnt) throws SQLException{

        List<Usuario> usus = new ArrayList<>();

        String sql = "select * from usuarios";

        PreparedStatement stmt = this.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario usu = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            usus.add(usu);
        }
        rs.close();
        stmt.close();
        return usus;
    }

    public Usuario Validar(Usuario usu) {
        try{
            String sql = "select * from usuarios WHERE login = ? AND senha = ?";

            PreparedStatement stmt = this.con.prepareStatement(sql);

            stmt.setString(1,usu.getLogin());
            stmt.setString(2,usu.getSenha());

            ResultSet rs = stmt.executeQuery();

            Usuario usuSaida = null;
            while (rs.next()) {
                usuSaida = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            stmt.close();
            usu = usuSaida;
            JOptionPane.showMessageDialog(null, "Validando Usuario...");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usu;
    }

}
