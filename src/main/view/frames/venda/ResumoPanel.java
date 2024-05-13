package main.view.frames.venda;

import javax.swing.*;
import java.awt.*;

public class ResumoPanel extends JPanel {
    
    public ResumoPanel(){
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Painel para o centro
        JPanel centroPanel = new JPanel();
        centroPanel.setBackground(Color.BLUE);
        add(centroPanel, BorderLayout.CENTER);

        // Painel para a parte inferior
        JPanel inferiorPanel = new JPanel();
        inferiorPanel.setBackground(Color.GREEN);
        add(inferiorPanel, BorderLayout.SOUTH);
    }

}
