package view.components;

import view.frames.menuprincipal.MenuPrincipal;

import javax.swing.*;

import java.awt.*;

public class Footer extends JPanel {
    private JLabel label;
    private JFrame menuPrincipal = new MenuPrincipal();
    public Footer(String text) {
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setLayout(new BorderLayout());

        JButton menuButton = new JButton("\u2630");
        menuButton.setFont(new Font("Arial", Font.PLAIN, 20));
        menuButton.setBorderPainted(false);
        menuButton.addActionListener((e)->{
            menuPrincipal.setVisible(true);
        });
        menuPanel.add(menuButton);
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setFont(new Font("Arial", Font.BOLD, 14));
        menuPanel.add(menuLabel);
        add(menuPanel, BorderLayout.WEST);


        label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
