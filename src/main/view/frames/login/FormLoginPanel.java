package main.view.frames.login;

import javax.swing.*;
import java.awt.*;

public class FormLoginPanel extends JPanel {

    public FormLoginPanel() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        // Configuração do GridBagConstraints para posicionar os componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Label e campo de entrada para o usuário
        JLabel userLabel = new JLabel("Usuário:");
        add(userLabel, gbc);

        gbc.gridx++;
        JTextField userField = new JTextField(15);
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        // Label e campo de entrada para a senha
        JLabel passwordLabel = new JLabel("Senha:");
        add(passwordLabel, gbc);

        gbc.gridx++;
        JPasswordField passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        // Botão de login
        JButton loginButton = new JButton("Entrar");
        add(loginButton, gbc);
    }
}
