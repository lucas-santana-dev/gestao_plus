package view.frames.menuprincipal;

import util.SetSizeRelativeToScreen;
import view.frames.clientes.ClientesFrame;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private final JPanel jpanelMenuPrincipal = new JPanel();
    private final ClientesFrame clientesFrame = new ClientesFrame();

    public MenuPrincipal(){
        setTitle("Menu Principal");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
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
            switch (text){
                case "Clientes":
                    clientesFrame.setVisible(true);
                    break;
            }
            }
        );
        return button;
    }
}
