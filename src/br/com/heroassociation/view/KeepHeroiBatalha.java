package br.com.heroassociation.view;

import br.com.heroassociation.controller.HeroiBatalhaController;
import br.com.heroassociation.model.bean.HeroiBatalha;
import javax.swing.*;
import java.sql.SQLException;

public class KeepHeroiBatalha {

    public static HeroiBatalhaController contHb;

    public static void Insert () throws SQLException, ClassNotFoundException {
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));
        int batalhaId = Integer.parseInt(JOptionPane.showInputDialog("Id da Batalha"));
        HeroiBatalha HeroiBatalha = new HeroiBatalha(heroiId, batalhaId);
        contHb = new HeroiBatalhaController();
        HeroiBatalha HbSaida = contHb.Insert(HeroiBatalha);
        JOptionPane.showMessageDialog(null,"" + HbSaida.toString());
    }

    public static void Select() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
        HeroiBatalha HbEntrada = new HeroiBatalha(id);
        contHb = new HeroiBatalhaController();
        HeroiBatalha HbSaida = contHb.Select(HbEntrada);
        JOptionPane.showMessageDialog(null,"" + HbSaida.toString());
    }

    public static void Update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("id do heroi"));
        int batalhaId = Integer.parseInt(JOptionPane.showInputDialog("id da Batalha"));
        HeroiBatalha HbEntrada = new HeroiBatalha(id, heroiId, batalhaId);
        contHb = new HeroiBatalhaController();
        HeroiBatalha HbSaida = contHb.Update(HbEntrada);
        JOptionPane.showMessageDialog(null, "" + HbSaida.toString());
    }

    public static void Delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        HeroiBatalha HbEntrada = new HeroiBatalha(id);
        contHb = new HeroiBatalhaController();
        HeroiBatalha HbSaida = contHb.Delete(HbEntrada);
        JOptionPane.showMessageDialog(null, HbSaida.toString());
    }

    public static void Menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir " +
                "\n 2 - Buscar \n 3 - Alterar \n 4 - Excluir \n 5 - Sair "));
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
