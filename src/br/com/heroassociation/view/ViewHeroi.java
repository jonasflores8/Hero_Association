package br.com.heroassociation.view;

import br.com.heroassociation.controller.HeroiController;
import br.com.heroassociation.model.bean.Heroi;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ViewHeroi {

    public static HeroiController contH;

    public static void Insert () throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome do Heroi");
        String identidade = JOptionPane.showInputDialog("Identidade Secreta");

        Heroi heroi = new Heroi(nome, identidade);
        HeroiController contHeroi = new HeroiController();
        Heroi hSaida = contHeroi.Insert(heroi);
        JOptionPane.showMessageDialog(null,"" + hSaida.toString());
    }

    public static void Select() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));

        Heroi hEntrada = new Heroi(id);
        contH = new HeroiController();
        Heroi hSaida = contH.Select(hEntrada);
        JOptionPane.showMessageDialog(null,"" + hSaida.toString());
    }

    public static void Update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));
        String nome = JOptionPane.showInputDialog("Nome do Heroi");
        String identidade = JOptionPane.showInputDialog("Identidade Secreta");

        Heroi hEntrada = new Heroi(id, nome, identidade);
        HeroiController contH = new HeroiController();
        Heroi hSaida = contH.Update(hEntrada);
        JOptionPane.showMessageDialog(null, "" + hSaida.toString());
    }

    public static void Delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));

        Heroi hEntrada = new Heroi(id);
        contH = new HeroiController();
        Heroi hSaida = contH.Delete(hEntrada);
        JOptionPane.showMessageDialog(null, hSaida.toString());
    }

    public static void Listar() throws SQLException, ClassNotFoundException {
        Heroi hEntrada = new Heroi();
        contH = new HeroiController();
        List<Heroi> listaHSaida = contH.Listar(hEntrada);
        for(Heroi h : listaHSaida) {
            JOptionPane.showMessageDialog(null, h.toString());
        }
    }

    public static void Menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir " +
                "\n 2 - Buscar \n 3 - Alterar \n 4 - Excluir \n 5 - Listar \n 6 - Sair "));
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
                JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente!");
                Menu();
                break;
        }
    }

}