package br.com.heroassociation;

import br.com.heroassociation.view.*;
import javax.swing.*;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        if(ViewUsuario.Validar()) {
            Menu();
        } else {
            JOptionPane.showMessageDialog(null,"Finalizado!");
        }

    }

    public static void Menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Usuario \n 2 - Heroi \n 3 - Arma " +
                "\n 4 - Batalha \n 5 - HeroiBatalha \n 6 - Sair"));
        switch (op) {
            case 1:
                ViewUsuario.Menu();
                Menu();
                break;
            case 2:
                ViewHeroi.Menu();
                Menu();
                break;
            case 3:
                ViewArma.Menu();
                Menu();
                break;
            case 4:
                ViewBatalha.Menu();
                Menu();
                break;
            case 5:
                ViewHeroiBatalha.Menu();
                Menu();
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