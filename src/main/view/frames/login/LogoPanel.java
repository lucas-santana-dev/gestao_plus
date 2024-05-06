package main.view.frames.login;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {

    public LogoPanel() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);//mudar para cor personalizada
        ImageIcon icon = new ImageIcon("src/main/img/supermarket.png");
        JLabel imageLabel = new JLabel();
        Image image = icon.getImage().getScaledInstance(217, 180, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        imageLabel.setIcon(scaledIcon);
        // Centralizando a imagem na JLabel
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);
    }

}
