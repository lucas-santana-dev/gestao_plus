package view.components;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private JLabel label;

    public Footer(String text) {
        setBackground(Color.LIGHT_GRAY);
        // Cria um JLabel com o texto recebido como parâmetro
        label = new JLabel(text);
        add(label, BorderLayout.SOUTH); // Adiciona o JLabel ao JPanel
    }
}
