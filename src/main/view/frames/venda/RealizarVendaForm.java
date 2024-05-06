package main.view.frames.venda;

import javax.swing.*;

import main.controller.ClienteController;
import main.controller.VendaController;
import main.model.ClienteModel;
import main.model.VendaModel;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

public class RealizarVendaForm extends JPanel {

    private JComboBox comboBoxClientes;
    public String clienteSelecionado;
    private JComboBox comboBoxPagamento;
    public String pagamentoSelecionado;
    private CaixaProdutos caixaProdutos;

    public RealizarVendaForm() {

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(new JLabel("Cliente:"), gbc);

        // array list com todos os clientes
        List<ClienteModel> clientes = ClienteController.carregarTodosClientes();

        gbc.gridx = 1;
        comboBoxClientes = new JComboBox<String>(); // colocar os nomes dos clientes

        for (int i = 0; i < clientes.size(); i++) {
            ClienteModel cliente = clientes.get(i);
            comboBoxClientes.addItem(cliente.getNome());
        }

        comboBoxClientes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                clienteSelecionado = (String) comboBoxClientes.getSelectedItem();
            }
        });
        add(comboBoxClientes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Forma de Pagamento:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        String[] formaPagamento = { "A vista", "Cartão", "Fiado" };
        comboBoxPagamento = new JComboBox<String>(formaPagamento);
        comboBoxPagamento.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                pagamentoSelecionado = (String) comboBoxPagamento.getSelectedItem();
            }
        });
        add(comboBoxPagamento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        caixaProdutos = new CaixaProdutos();
        add(caixaProdutos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendaModel novaVenda = new VendaModel();
                ClienteModel cliente;
                for (int i = 0; i < clientes.size(); i++) {
                    cliente = clientes.get(i);
                    if (cliente.getNome() == clienteSelecionado) {
                        novaVenda.setCliente(cliente);
                    }
                }

                novaVenda.setFormaPagamento(pagamentoSelecionado);
                novaVenda.setProdutos(caixaProdutos.produtosSelecionados);
                novaVenda.setValorCompra(caixaProdutos.soma);

                boolean vendaSalvaComSucesso = VendaController.salvarNovaVenda(novaVenda);
                if (vendaSalvaComSucesso) {
                    JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao realizar a venda. Por favor, tente novamente.");
                }

            }
        });
        add(botaoSalvar, gbc);

    }
}