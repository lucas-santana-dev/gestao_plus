package main.view.frames.venda;

import main.util.SetSizeRelativeToScreen;

import javax.swing.*;

public class VendaFrame extends JFrame {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private RealizarVendaForm realizarVendaForm = new RealizarVendaForm();

    public VendaFrame() {
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.8);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Venda");
        // setSize(700, 600);
        add(tabbedPane);

        tabbedPane.addTab("Realizar Venda", realizarVendaForm);

        pack();
        setVisible(true);
    }

}
