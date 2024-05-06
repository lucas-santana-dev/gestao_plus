package main.view.frames.menuprincipal;

import main.util.SetSizeRelativeToScreen;
import main.view.frames.clientes.ClientesFrame;
import main.view.frames.pedido.PedidoFrame;
import main.view.frames.produtos.ProdutosFrame;
import main.view.frames.venda.VendaFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private final JPanel jpanelMenuPrincipal = new JPanel();

    public MenuPrincipal() {
        setTitle("Menu Principal");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        jpanelMenuPrincipal.setLayout(new GridLayout(2, 3));

        String[] nomes = { "Clientes", "Produtos", "Vender", "Estoque", };

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
        button.setPreferredSize(new Dimension(90, 90)); // Tamanho do botão
        // button.setContentAreaFilled(false);
        button.setBackground(Color.WHITE);
        button.setRolloverSelectedIcon(null);
        button.setFocusPainted(false);
        button.setRolloverEnabled(false);
        // Caminho do ícone
        String iconPath = "src/main/img/" + text.toLowerCase() + ".png";

        // Carregar o ícone do arquivo especificado
        try {
            File file = new File(iconPath);
            if (file.exists()) {
                ImageIcon icon = new ImageIcon(ImageIO.read(file));
                Image scaledImage = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(scaledImage));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        button.addActionListener((e) -> {
            switch (text) {
                case "Clientes":
                    ClientesFrame clientesFrame = new ClientesFrame();
                    clientesFrame.setVisible(true);
                    break;
                case "Produtos":
                    ProdutosFrame produtosFrame = new ProdutosFrame();
                    produtosFrame.setVisible(true);
                    break;
                case "Vender":
                    VendaFrame vendaFrame = new VendaFrame();
                    vendaFrame.setVisible(true);
                    break;
                case "Estoque":
                    PedidoFrame pedidoFrame = new PedidoFrame();
                    pedidoFrame.setVisible(true);
                    break;
                // Adicione mais cases conforme necessário
            }
        });
        return button;
    }
}
