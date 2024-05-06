package main.view.frames.pedido;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import main.util.SetSizeRelativeToScreen;

public class PedidoFrame extends JFrame {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private RealizarPedidoForm realizarPedidoForm = new RealizarPedidoForm();

    public PedidoFrame() {
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.8);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pedido");
        add(tabbedPane);

        tabbedPane.addTab("Realizar Venda", realizarPedidoForm);

        // pack();
        setVisible(true);
    }

}
