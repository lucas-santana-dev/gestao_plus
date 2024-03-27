package view.frames.clientes;

import util.SetSizeRelativeToScreen;
import view.components.CadastroClienteForm;

import javax.swing.*;
import java.awt.*;

public class ClientesFrame extends JFrame{

    CadastroClienteForm cadastroClienteForm = new CadastroClienteForm();
    public ClientesFrame(){
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Clientes");

        // Definindo layout da tela principal
        getContentPane().setLayout(new BorderLayout());

        // Adicionando o CadastroClienteForm ao painel esquerdo
        JPanel panelEsquerdo = new JPanel(new BorderLayout());
        panelEsquerdo.add(cadastroClienteForm, BorderLayout.CENTER);

        // Adicionando o painel esquerdo e direito ao JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelEsquerdo,panelEsquerdo);
        splitPane.setResizeWeight(0.5); // Define a proporção inicial de redimensionamento

        // Adicionando o JSplitPane à tela principal
        getContentPane().add(splitPane, BorderLayout.CENTER);
        add(cadastroClienteForm);


    }
}
