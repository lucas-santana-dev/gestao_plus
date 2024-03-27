package view.components;

import util.SetSizeRelativeToScreen;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private JPanel jpanelMenuPrincipal = new JPanel();

    public MenuPrincipal(){
        setTitle("Menu Principal");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);

        setResizable(false);
        setLocationRelativeTo(null); // Abre a janela no meio da tela
        jpanelMenuPrincipal.setLayout(new GridLayout(2, 3));

        String[] nomes = {"Clientes", "Produtos", "Abrir Cupom", "Estoque", };

        for (String nomeBotao : nomes) {
            JButton button = createSquareButton(nomeBotao);
            jpanelMenuPrincipal.add(button);
        }

        add(jpanelMenuPrincipal);
        setVisible(true);
    }

    private JButton createSquareButton(String text) {
        JButton button = new JButton(text);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(100, 100)); // Tamanho do botão
        button.addActionListener((e)-> {
                //lógica a ser executada quando o botão for clicado
                JOptionPane.showMessageDialog(MenuPrincipal.this, "Botão " + text + " clicado!");
            }
        );
        return button;
    }
}
