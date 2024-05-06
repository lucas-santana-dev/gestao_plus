package main.view.frames.mainframe;

import main.util.SetSizeRelativeToScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final MainPanel mainPanel = new MainPanel();
    private final Footer footer = new Footer("Não tão orgulhosamente feito com JAVA © 2024 by Lucas Santana");
    private final SideBar sideBar = new SideBar();

    public MainFrame() {
        setTitle("Gestão Plus - O App de gestão para seu negócio");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.9, 0.9);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        // Adicionando BorderLayout ao JFrame
        setLayout(new BorderLayout());

        // Criando e adicionando um JPanel preto na região WEST

        add(sideBar, BorderLayout.WEST);

        // Adicionando o MainPanel na região CENTER
        add(mainPanel, BorderLayout.CENTER);

        // Adicionando o Footer na região SOUTH
        add(footer, BorderLayout.SOUTH);
    }
}
