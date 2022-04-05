package br.com.heroassociation.view;

import br.com.heroassociation.controller.BatalhaController;
import br.com.heroassociation.model.bean.Batalha;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ViewBatalha {

    public static BatalhaController contB;

    public static void Insert () throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome da Batalha");
        String descricao = JOptionPane.showInputDialog("Descrição");
        float duracao = Float.parseFloat(JOptionPane.showInputDialog("Duração da Batalha"));

        Batalha Batalha = new Batalha(nome, descricao, duracao);
        contB = new BatalhaController();
        Batalha bSaida = contB.Insert(Batalha);
        JOptionPane.showMessageDialog(null,"" + bSaida.toString());
    }

    public static void Select() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Batalha"));

        Batalha bEntrada = new Batalha(id);
        contB = new BatalhaController();
        Batalha bSaida = contB.Select(bEntrada);
        JOptionPane.showMessageDialog(null,"" + bSaida.toString());
    }

    public static void Update() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Batalha"));
        String nome = JOptionPane.showInputDialog("Nome da Batalha");
        String descricao = JOptionPane.showInputDialog("Descricao");
        float duracao = Float.parseFloat(JOptionPane.showInputDialog("Duração da Batalha"));

        Batalha bEntrada = new Batalha(id, nome, descricao, duracao);
        contB = new BatalhaController();
        Batalha bSaida = contB.Update(bEntrada);
        JOptionPane.showMessageDialog(null, "" + bSaida.toString());
    }

    public static void Delete() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id da Batalha"));

        Batalha bEntrada = new Batalha(id);
        contB = new BatalhaController();
        Batalha bSaida = contB.Delete(bEntrada);
        JOptionPane.showMessageDialog(null, bSaida.toString());
    }

    public static void Listar() throws SQLException, ClassNotFoundException {
        Batalha bEntrada = new Batalha();
        contB = new BatalhaController();
        List<Batalha> listaBSaida = contB.Listar(bEntrada);
        for(Batalha b : listaBSaida) {
            JOptionPane.showMessageDialog(null, b.toString());
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
