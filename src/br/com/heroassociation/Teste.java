package br.com.heroassociation;

import br.com.heroassociation.view.*;
import javax.swing.*;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        if(KeepUsuario.Validar()) {
            Menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido!");
        }

    }

    public static void Menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Usuario \n 2 - Heroi \n 3 - Arma " +
                "\n 4 - Batalha \n 5 - HeroiBatalha \n 6 - Sair"));
        switch (op) {
            case 1:
                KeepUsuario.Menu();
                Menu();
                break;
            case 2:
                KeepHeroi.Menu();
                Menu();
                break;
            case 3:
                KeepArma.Menu();
                Menu();
                break;
            case 4:
                KeepBatalha.Menu();
                Menu();
                break;
            case 5:
                KeepHeroiBatalha.Menu();
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