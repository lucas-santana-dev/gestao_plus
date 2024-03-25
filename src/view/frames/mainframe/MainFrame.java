package view.frames.mainframe;

import util.SetSizeRelativeToScreen;
import view.components.CadastroClienteForm;
import view.components.Footer;
import view.components.MenuLateral;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MenuLateral menuLateral;
    private Footer footer;

    private CadastroClienteForm cadastroClienteForm;

    public MainFrame() {
        setTitle("Gestão Plus - O App de gestão para seu negócio");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.7, 0.7);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        menuLateral = new MenuLateral();

        // Cria uma instância do formulário de cadastro de cliente
        cadastroClienteForm = new CadastroClienteForm();

        // Adiciona o formulário na posição BorderLayout.CENTER
        add(cadastroClienteForm, BorderLayout.CENTER);
        add(menuLateral, BorderLayout.WEST);


        Footer footer = new Footer("Não tão orgulhosamente feito com JAVA © 2024 by Lucas Santana");
        add(footer,BorderLayout.SOUTH);
        setLocationRelativeTo(null); // Abre a janela no meio da tela
        setVisible(true);
    }


}
