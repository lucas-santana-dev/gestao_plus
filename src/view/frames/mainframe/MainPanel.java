package view.frames.mainframe;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(){
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("src/img/supermarket.png");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        add(imageLabel, BorderLayout.CENTER);
    }
}
