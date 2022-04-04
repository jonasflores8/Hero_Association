package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.Usuario;
import br.com.heroassociation.model.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {

    DaoUsuario daoUsu = null;

    public Usuario Insert (Usuario u) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.Insert(u);
    }

    public Usuario Select (Usuario u) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.Select(u);
    }

    public Usuario Update (Usuario u) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.Update(u);
    }

    public Usuario Delete (Usuario u) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.Delete(u);
    }

    public List<Usuario> Listar (Usuario u) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        return daoUsu.Listar(u);
    }

    public Boolean Validar (Usuario u) throws SQLException, ClassNotFoundException {
        boolean validado = false;
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.Validar(u);
        if(usuSaida.getLogin().equals("jonas") & usuSaida.getSenha().equals("xxx")) {
            validado = true;
        }
        return validado;
    }

}
