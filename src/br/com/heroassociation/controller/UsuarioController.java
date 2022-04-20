package br.com.heroassociation.controller;

import br.com.heroassociation.model.bean.Usuario;
import br.com.heroassociation.model.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {

    DaoUsuario daoUsu = null;

    public UsuarioController() throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
    }

    public Usuario Insert (Usuario u) {
        return daoUsu.Insert(u);
    }

    public Usuario Select (Usuario u) {
        return daoUsu.Select(u);
    }

    public Usuario Update (Usuario u) {
        return daoUsu.Update(u);
    }

    public Usuario Delete (Usuario u) {
        return daoUsu.Delete(u);
    }

    public List<Usuario> Listar (Usuario u) {
        return daoUsu.Listar(u);
    }

    public Boolean Validar (Usuario u) {
        boolean validado = false;
        Usuario usuSaida = daoUsu.Validar(u);
        if(usuSaida != null) {
            validado = true;
        }
        return validado;
    }

}
