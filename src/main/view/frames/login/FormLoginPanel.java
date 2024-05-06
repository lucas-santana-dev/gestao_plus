package main.view.frames.login;

import javax.swing.*;
import java.awt.*;
public class FormLoginPanel extends JPanel {

    public FormLoginPanel() {
        initializeUI();
    }

    private void initializeUI() {
        // Define o layout GridBagLayout para maior flexibilidade
        setLayout(new GridBagLayout());

        // Adiciona espaçamento ao redor do formulário
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno

        // Label e campo de entrada para o usuário
        JLabel userLabel = new JLabel("Usuario:");
        add(userLabel, gbc);

        gbc.gridy++;
        JTextField userField = new JTextField(20);
        userField.setPreferredSize(new Dimension(280, 30)); // Ajusta a largura e altura do campo de texto
        add(userField, gbc);

        // Label e campo de entrada para a senha
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Senha:");
        add(passwordLabel, gbc);

        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(280, 30)); // Ajusta a largura e altura do campo de texto
        add(passwordField, gbc);

        // Botão de login
        gbc.gridy++;
        JButton loginButton = new JButton("Entrar");
        loginButton.setPreferredSize(new Dimension(280, 35)); // Ajusta a largura e altura do botão
        add(loginButton, gbc);
    }



}
