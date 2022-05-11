package br.com.heroassociation.view;

import br.com.heroassociation.controller.ArmaController;
import br.com.heroassociation.model.bean.Arma;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ViewArma {

    static ArmaController contA;

    public static void Insert() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome da Arma");
        String tipo = JOptionPane.showInputDialog("Tipo de Arma");
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));

        Arma arma = new Arma(nome,tipo, heroiId);
        contA = new ArmaController();
        Arma aSaida = contA.Insert(arma);
        JOptionPane.showMessageDialog(null,"" + aSaida.toString());
    }

    public static void Select() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Arma"));

        Arma aEntrada = new Arma(id);
        contA = new ArmaController();
        Arma aSaida = contA.Select(aEntrada);
        JOptionPane.showMessageDialog(null,"" + aSaida.toString());
    }

    public static void Update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Arma"));
        String nome = JOptionPane.showInputDialog("Nome da Arma");
        String tipo = JOptionPane.showInputDialog("Tipo de Arma");
        int heroiId = Integer.parseInt(JOptionPane.showInputDialog("Id do Heroi"));

        Arma aEntrada = new Arma(id, nome, tipo, heroiId);
        ArmaController contA = new ArmaController();
        Arma aSaida = contA.Update(aEntrada);
        JOptionPane.showMessageDialog(null, "" + aSaida.toString());
    }

    public static void Delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Arma"));

        Arma aEntrada = new Arma(id);
        contA = new ArmaController();
        Arma aSaida = contA.Delete(aEntrada);
        JOptionPane.showMessageDialog(null, aSaida.toString());
    }

    public static void Listar() throws SQLException, ClassNotFoundException {
        Arma aEntrada = new Arma();
        contA = new ArmaController();
        List<Arma> listaASaida = contA.Listar(aEntrada);
        for(Arma a : listaASaida) {
            JOptionPane.showMessageDialog(null, a.toString());
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
