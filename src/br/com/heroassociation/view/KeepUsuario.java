package br.com.heroassociation.view;

import javax.swing.JOptionPane;
import br.com.heroassociation.model.bean.Usuario;
import br.com.heroassociation.controller.UsuarioController;
import java.sql.SQLException;
import java.util.List;

public class KeepUsuario {

    public static void Insert () throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        String tipo = JOptionPane.showInputDialog("Tipo");
        Usuario usuEntrada = new Usuario(login, Senha, status,tipo);
        UsuarioController contUsu = new UsuarioController();
        Usuario usuSaida = contUsu.Insert(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }

    public static void Select () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        Usuario usuEntrada = new Usuario(id);
        UsuarioController contUsu = new UsuarioController();
        Usuario usuSaida = contUsu.Select(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());

    }

    public static void Update () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        String status = JOptionPane.showInputDialog("Status");
        String tipo = JOptionPane.showInputDialog("Tipo");
        Usuario usuEntrada = new Usuario(id,login, Senha, status,tipo);
        UsuarioController contUsu = new UsuarioController();
        Usuario usuSaida = contUsu.Update(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }

    public static void Delete () throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        Usuario usuEntrada = new Usuario(id);
        UsuarioController contUsu = new UsuarioController();
        Usuario usuSaida = contUsu.Delete(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + usuSaida.toString());
    }

    public static void Listar () throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Login");
        Usuario usuEntrada = new Usuario(login);
        UsuarioController contUsu = new UsuarioController();
        List<Usuario> lista = contUsu.Listar(usuEntrada);
        JOptionPane.showMessageDialog(null,"" + lista.get(0).getLogin());
    }

    public static boolean Validar () throws SQLException, ClassNotFoundException {
        boolean validado = false;
        String login = JOptionPane.showInputDialog("Login");
        String Senha = JOptionPane.showInputDialog("Senha");
        Usuario usuEntrada = new Usuario(login, Senha);
        UsuarioController contUsu = new UsuarioController();
        validado = contUsu.Validar(usuEntrada);
        return validado;
    }

    public static void Menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir \n 2 - Buscar " +
                "\n 3 - Alterar \n 4 - Excluir \n 5 - Listar"));
        switch (op) {
            case 1:
                Insert();
                break;
            case 2:
                Select();
                break;
            case 3:
                Update();
                break;
            case 4:
                Delete();
                break;
            case 5:
                Listar();
                break;
            case 6:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair?");
                if(sair > 0) Menu();
                break;
            default:
                JOptionPane.showMessageDialog(null,"opção inválida, tente novamente");
                Menu();
                break;
        }
    }

}