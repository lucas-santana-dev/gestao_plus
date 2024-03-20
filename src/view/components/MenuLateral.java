package view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuLateral extends JPanel {
    private final JList<String> optionList;

    public MenuLateral() {
        setLayout(new BorderLayout());

        // Adiciona um JLabel com o texto desejado antes da lista de opções
        JLabel label = new JLabel("Selecione uma opção:");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
        add(label, BorderLayout.NORTH);

        // Opções desejadas
        String[] options = {"Cadastrar Cliente", "Cadastrar Produto", "Vender", "Consultar Vendas", "Estoque"};

        // Modelo para a lista com as opções
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String option : options) {
            listModel.addElement(option);
        }

        // JList com o modelo
        optionList = new JList<>(listModel);
        optionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Ouvinte de evento de clique na lista
        optionList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Verifica se foi um clique duplo
                    int selectedIndex = optionList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String selectedOption = listModel.getElementAt(selectedIndex);
                        System.out.println("Opção selecionada: " + selectedOption);
                        // TODO: Adicionar lógica para mudar o JPanel Central de acordo com a opção selecionada
                    }
                }
            }
        });

        // Adiciona a lista a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(optionList);
        add(scrollPane, BorderLayout.CENTER);
    }
}
