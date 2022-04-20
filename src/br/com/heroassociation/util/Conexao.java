package br.com.heroassociation.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class Conexao {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/heroapp";
            String usuario = "root";
            String senha = "123456";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLSyntaxErrorException se){
            JOptionPane.showMessageDialog(null, se);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
