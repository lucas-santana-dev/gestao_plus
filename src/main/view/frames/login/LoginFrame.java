package main.view.frames.login;

import main.util.SetSizeRelativeToScreen;
import main.view.frames.mainframe.MainPanel;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private final LogoPanel logoPanel = new LogoPanel();
    private final FormLoginPanel formLoginPanel = new FormLoginPanel();
    public LoginFrame() {
        setTitle("SuperMarket - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Chama o método para inicializar a UI
        initializeUI();

        // Define o tamanho da tela relativo à tela do usuário
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.5, 0.5);

        // Torna o frame visível após a configuração
        setVisible(true);
    }

    private void initializeUI() {
        // Cria um painel principal com layout GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBackground(Color.GRAY);


        // Adiciona os painéis leftPanel e rightPanel ao painel principal usando GridLayout
        mainPanel.add(logoPanel);
        mainPanel.add(formLoginPanel);

        // Define o painel principal como o conteúdo do JFrame
        setContentPane(mainPanel);
    }
}
