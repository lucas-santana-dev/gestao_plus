package view.frames.clientes;

import util.SetSizeRelativeToScreen;
import view.components.CadastroClienteForm;
import view.components.ListagemClientesPanel;

import javax.swing.*;
import java.awt.*;

public class ClientesFrame extends JFrame {

    // Criando uma instância de JTabbedPane
    private JTabbedPane tabbedPane = new JTabbedPane();
    private CadastroClienteForm cadastroClienteForm = new CadastroClienteForm();
    private final ListagemClientesPanel listagemClientesPanel = new ListagemClientesPanel();
    public ClientesFrame() {
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Clientes");
        add(tabbedPane);

        tabbedPane.addTab("Cadastro de Cliente", cadastroClienteForm);

        tabbedPane.addTab("Lista de Clientes", listagemClientesPanel); // Substitua JPanel pelo componente que desejar

        setVisible(true);
    }
}
