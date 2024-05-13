package main.view.frames.mainframe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel {
    private ActionListener actionListener;

    public SideBar() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        Color customColor = Color.decode("#1894ac");
        Color cardColorPadrao = Color.decode("#84ccdc");

        // Criando e adicionando o TopPanel branco no topo (NORTH)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(customColor);
        topPanel.setPreferredSize(new Dimension(getWidth(), 150)); // Defina a altura desejada do painel branco

        // Carregando a imagem e redimensionando para caber no topo
        ImageIcon icon = new ImageIcon("src/main/img/supermarket.png");
        Image scaledImage = icon.getImage().getScaledInstance(-1, 80, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Criando o JLabel para exibir a imagem centralizada
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centralizando horizontalmente
        imageLabel.setVerticalAlignment(SwingConstants.CENTER); // Centralizando verticalmente
        topPanel.add(imageLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Adicionando um divisor entre o topo e o restante do conteúdo
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(getWidth(), 1)); // Defina a largura do divisor
        separator.setBackground(Color.BLACK); // Defina a cor do divisor
        add(separator, BorderLayout.CENTER);

        // Adicionando o grid de cards abaixo do divisor
        int CARD_SIZE = 95; // Variável para representar o tamanho dos cards

        // Adicionando o grid de cards abaixo do divisor
        JPanel cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 1)); // FlowLayout com espaçamento de 1 pixel
        cardsPanel.setBorder(new EmptyBorder(1, 1, 1, 1)); // Espaçamento interno dos cards
        cardsPanel.setBackground(customColor);

        addButton(cardColorPadrao, cardsPanel, CARD_SIZE, "NovaVenda", "src/main/img/vender.png");
        addButton(cardColorPadrao, cardsPanel, CARD_SIZE, "Clientes", "src/main/img/clientes.png");
        addButton(cardColorPadrao, cardsPanel, CARD_SIZE, "Produtos", "src/main/img/produtos.png");
        addButton(cardColorPadrao, cardsPanel, CARD_SIZE, "Estoque", "src/main/img/estoque.png");

        add(cardsPanel, BorderLayout.CENTER);

        int width = 200; // Defina o valor que desejar
        setBackground(customColor);
        setPreferredSize(new Dimension(width, getHeight()));
    }

    private void addButton(Color cardColorPadrao, JPanel cardsPanel, int CARD_SIZE, String labelText, String imagePath) {
        JButton card = new JButton();
        card.setPreferredSize(new Dimension(CARD_SIZE, CARD_SIZE)); // Definindo tamanho usando a variável
        card.setBackground(cardColorPadrao); // Cor padrão
        card.setForeground(Color.WHITE); // Cor do texto
        card.setLayout(new BorderLayout()); // Definindo layout para BorderLayout para posicionar os componentes
        ImageIcon icon = new ImageIcon(imagePath); // Substitua com o caminho do seu ícone
        Image scaledIcon = icon.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        JLabel iconLabel = new JLabel(new ImageIcon(scaledIcon));
        card.add(iconLabel, BorderLayout.WEST);
        JLabel textLabel = new JLabel(labelText);
        textLabel.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        card.add(textLabel, BorderLayout.SOUTH); //
        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, labelText));
                }
            }
        });
        cardsPanel.add(card);
    }

    // Método para adicionar o ActionListener externamente
    public void addActionListener(ActionListener listener) {
        this.actionListener = listener;
    }
}
