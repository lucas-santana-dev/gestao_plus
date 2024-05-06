package main.view.frames.pedido;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.*;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.awt.event.ItemEvent;

import main.controller.ProdutoController;
import main.model.ProdutoModel;
import java.util.List;

public class RealizarPedidoForm extends JPanel {

    private JComboBox comboBoxProdutos;
    public String produtoSelecionado;
    private JFormattedTextField precoCompra;
    private JFormattedTextField dataFabricacao;
    private JFormattedTextField dataValidade;
    private JTextField quantidade;

    public RealizarPedidoForm() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Produto:"), gbc);

        // array list com todos os produtos
        List<ProdutoModel> produtos = ProdutoController.carregarTodosProdutos();

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha

        comboBoxProdutos = new JComboBox<String>(); // colocar os nomes dos produtos

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoModel produto = produtos.get(i);
            comboBoxProdutos.addItem(produto.getNomeProduto());
        }

        comboBoxProdutos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                produtoSelecionado = (String) comboBoxProdutos.getSelectedItem();
            }
        });
        add(comboBoxProdutos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        precoCompra = new JFormattedTextField(createDoubleFormatter());
        precoCompra.setColumns(15);
        add(precoCompra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Data de Fabricação (dd/MM/aaaa):"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        dataFabricacao = createFormattedTextField();
        add(dataFabricacao, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Data de Validade (dd/MM/aaaa):"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        dataValidade = createFormattedTextField();
        add(dataValidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Quantidade:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        quantidade = new JTextField(15);
        add(quantidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botaoFinalizar = new JButton("Finalizar");
        add(botaoFinalizar, gbc);

    }

    // funções de formatação

    private JFormattedTextField createFormattedTextField() {
        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            JFormattedTextField textField = new JFormattedTextField(formatter);
            textField.setColumns(15);
            return textField;
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private NumberFormatter createDoubleFormatter() {
        java.text.NumberFormat format = java.text.NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return new javax.swing.text.NumberFormatter(format);
    }

}
