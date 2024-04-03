package main.view.frames.menuprincipal;

import main.util.SetSizeRelativeToScreen;
import main.view.frames.clientes.ClientesFrame;
import main.view.frames.produtos.ProdutosFrame;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private final JPanel jpanelMenuPrincipal = new JPanel();


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
                    ClientesFrame clientesFrame = new ClientesFrame();
                    clientesFrame.setVisible(true);
                    break;
                case  "Produtos":
                    ProdutosFrame produtosFrame = new ProdutosFrame();
                    produtosFrame.setVisible(true);
                    break;
            }
            }
        );
        return button;
    }
}
