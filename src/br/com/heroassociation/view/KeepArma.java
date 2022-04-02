package br.com.heroassociation.view;

import br.com.heroassociation.controller.ArmaController;
import br.com.heroassociation.model.bean.Arma;
import javax.swing.*;
import java.sql.SQLException;

public class KeepArma {

    static ArmaController contA;

    public static void Insert() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome da arma");
        String tipo = JOptionPane.showInputDialog("Tipo de arma");
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("Id do heroi"));

        Arma arma = new Arma(nome,tipo,heroiId);
        contA = new ArmaController();
        Arma aSaida = contA.Insert(arma);
        JOptionPane.showMessageDialog(null,"" + aSaida.toString());
    }

    public static void Select() throws SQLException, ClassNotFoundException {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
            Arma aEntrada = new Arma(id);
            contA = new ArmaController();
            Arma aSaida = contA.Select(aEntrada);
            JOptionPane.showMessageDialog(null,"" + aSaida.toString());
    }

    public static void Update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        String nome = JOptionPane.showInputDialog("Nome");
        String tipo = JOptionPane.showInputDialog("Tipo");
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));
        Arma aEntrada = new Arma(id, nome, tipo, heroiId);
        ArmaController contA = new ArmaController();
        Arma aSaida = contA.Update(aEntrada);
        JOptionPane.showMessageDialog(null, "" + aSaida.toString());
    }

    public static void Delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
        Arma aEntrada = new Arma(id);
        contA = new ArmaController();
        Arma aSaida = contA.Delete(aEntrada);
        JOptionPane.showMessageDialog(null, aSaida.toString());
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
