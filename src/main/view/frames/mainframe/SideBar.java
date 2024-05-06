package main.view.frames.mainframe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBar extends JPanel {

    public SideBar(){
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

        JButton card1 = new JButton();
        card1.setPreferredSize(new Dimension(CARD_SIZE, CARD_SIZE)); // Definindo tamanho usando a variável
        card1.setBackground(cardColorPadrao); // Cor padrão
        card1.setForeground(Color.WHITE); // Cor do texto
        card1.setLayout(new BorderLayout()); // Definindo layout para BorderLayout para posicionar os componentes
        ImageIcon icon1 = new ImageIcon("src/main/img/vender.png"); // Substitua com o caminho do seu ícone
        Image scaledIcon1 = icon1.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        JLabel iconLabel1 = new JLabel(new ImageIcon(scaledIcon1));
        card1.add(iconLabel1, BorderLayout.WEST);
        JLabel textLabel1 = new JLabel("Nova Venda");
        textLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
        card1.add(textLabel1, BorderLayout.SOUTH); //
        card1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloque aqui o código a ser executado quando o botão (card) 1 for clicado
            }
        });
        cardsPanel.add(card1);

        JButton card2 = new JButton();
        card2.setPreferredSize(new Dimension(CARD_SIZE, CARD_SIZE)); // Definindo tamanho usando a variável
        card2.setBackground(cardColorPadrao); // Cor padrão
        card2.setForeground(Color.WHITE); // Cor do texto
        card2.setLayout(new BorderLayout()); // Definindo layout para BorderLayout para posicionar os componentes
        ImageIcon icon2 = new ImageIcon("src/main/img/clientes.png"); // Substitua com o caminho do seu ícone
        Image scaledIcon2 = icon2.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        JLabel iconLabel2 = new JLabel(new ImageIcon(scaledIcon2));
        card2.add(iconLabel2, BorderLayout.WEST);
        JLabel textLabel2 = new JLabel("Clientes");
        textLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
        card2.add(textLabel2, BorderLayout.SOUTH); //
        card2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloque aqui o código a ser executado quando o botão (card) 2 for clicado
            }
        });
        cardsPanel.add(card2);
        JButton card3 = new JButton();
        card3.setPreferredSize(new Dimension(CARD_SIZE, CARD_SIZE)); // Definindo tamanho usando a variável
        card3.setBackground(cardColorPadrao);
        card3.setForeground(Color.WHITE); // Cor do texto
        card3.setLayout(new BorderLayout());
        ImageIcon icon3 = new ImageIcon("src/main/img/produtos.png"); // Substitua com o caminho do seu ícone
        Image scaledIcon3 = icon3.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        JLabel iconLabel3 = new JLabel(new ImageIcon(scaledIcon3));
        card3.add(iconLabel3, BorderLayout.WEST);
        JLabel textLabel3 = new JLabel("Produtos");
        textLabel3.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
        card3.add(textLabel3, BorderLayout.SOUTH); //
        card3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloque aqui o código a ser executado quando o botão (card) 3 for clicado
            }
        });
        cardsPanel.add(card3);

        JButton card4 = new JButton();
        card4.setPreferredSize(new Dimension(CARD_SIZE, CARD_SIZE)); // Definindo tamanho usando a variável
        card4.setBackground(cardColorPadrao);
        card4.setForeground(Color.WHITE); // Cor do texto
        card4.setLayout(new BorderLayout());
        ImageIcon icon4 = new ImageIcon("src/main/img/estoque.png"); // Substitua com o caminho do seu ícone
        Image scaledIcon4 = icon4.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH); // Ajuste a altura conforme necessário
        JLabel iconLabel4 = new JLabel(new ImageIcon(scaledIcon4));
        card4.add(iconLabel4, BorderLayout.WEST);
        JLabel textLabel4 = new JLabel("Estoque");
        textLabel4.setHorizontalAlignment(SwingConstants.LEFT);
        textLabel4.setVerticalAlignment(SwingConstants.BOTTOM);
        card4.add(textLabel4, BorderLayout.SOUTH); //

        card4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloque aqui o código a ser executado quando o botão (card) 4 for clicado
            }
        });
        cardsPanel.add(card4);

        add(cardsPanel, BorderLayout.CENTER);

        int width = 200; // Defina o valor que desejar
        setBackground(customColor);
        setPreferredSize(new Dimension(width, getHeight()));
    }

}
