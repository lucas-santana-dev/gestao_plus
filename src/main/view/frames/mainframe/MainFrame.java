package main.view.frames.mainframe;

import main.util.SetSizeRelativeToScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final MainPanel mainPanel = new MainPanel();
    private final Footer footer = new Footer("Não tão orgulhosamente feito com JAVA © 2024 by Lucas Santana");

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

        {
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(Color.WHITE);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.CENTER;
            panel.add(mainPanel, gbc);
            add(panel, BorderLayout.CENTER);
        }

        {
            add(footer, BorderLayout.SOUTH);
        }
    }
}
