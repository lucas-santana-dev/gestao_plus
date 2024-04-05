package main.view.frames.venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.controller.ProdutoController;
import main.model.ProdutoModel;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CaixaProdutos extends JComponent {

    private JScrollPane scrollPaneLista;
    private JList listaProdutos;
    private DefaultListModel modeloLista;
    private JButton btnAdicionar;
    private JScrollPane scrollPaneTabela;
    private JTable tabelaCompra;
    private DefaultTableModel modeloTabela;
    private JButton btnRemover;

    List<ProdutoModel> produtos = ProdutoController.carregarTodosProdutos();

    public CaixaProdutos() {
        GridLayout gridLayout = new GridLayout(0, 2);
        gridLayout.setHgap(15);
        setLayout(gridLayout);

        // inicializa os componentes

        modeloLista = new DefaultListModel<String>();

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoModel produto = produtos.get(i);

            modeloLista.addElement(produto.getNomeProduto());
        }

        listaProdutos = new JList<>(modeloLista);
        listaProdutos.setVisibleRowCount(5);
        listaProdutos.setFixedCellWidth(200);
        listaProdutos.setFixedCellHeight(15);
        listaProdutos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPaneLista = new JScrollPane(listaProdutos);
        scrollPaneLista.setSize(200, 15);
        btnAdicionar = new JButton("Adicionar >>");
        btnAdicionar.addActionListener((ActionEvent e) -> {
            // obtém a lista de todos os produtos
            List<String> listProd = listaProdutos.getSelectedValuesList();

            // percorre toda a lista dos produtos
            for (int i = 0; i < listProd.size(); i++) {

                String produtoSelecionado = listProd.get(i);

                // compara o produto selecionado com a lista de produtos do database
                for (int j = 0; j < produtos.size(); j++) {
                    ProdutoModel produto = produtos.get(j); // obtém todos os produtos cadastrados
                    if (produto.getNomeProduto() == produtoSelecionado) {
                        modeloTabela.addRow(new Object[] { produto.getNomeProduto(), "", produto.getPrecoVenda() });
                    }
                    modeloLista.removeElement(produtoSelecionado);
                }
            }
        });

        Object[] colunas = { "Produto", "Quantidade", "Valor" };
        modeloTabela = new DefaultTableModel();
        modeloTabela.setColumnIdentifiers(colunas);
        tabelaCompra = new JTable();
        tabelaCompra.setModel(modeloTabela);
        tabelaCompra.setBounds(0, 0, 200, 15);
        scrollPaneTabela = new JScrollPane(tabelaCompra);
        scrollPaneTabela.setSize(200, 15);
        btnRemover = new JButton("<< Remover");
        btnRemover.addActionListener((ActionEvent e) -> {
            // obtém o produto que deseja remover
            int linha = tabelaCompra.getSelectedRow();
            modeloLista.addElement(tabelaCompra.getValueAt(linha, 0));
            modeloTabela.removeRow(linha);
        });

        // configurar o layout da esquerda
        JPanel painelEsquerda = new JPanel(new BorderLayout());
        painelEsquerda.add(new Label("Produtos"), BorderLayout.NORTH);
        painelEsquerda.add(scrollPaneLista, BorderLayout.CENTER);
        painelEsquerda.add(btnAdicionar, BorderLayout.SOUTH);

        // configurar o layout da direita
        JPanel painelDireita = new JPanel(new BorderLayout());
        painelDireita.add(new Label("Compras"), BorderLayout.NORTH);
        painelDireita.add(scrollPaneTabela, BorderLayout.CENTER);
        painelDireita.add(btnRemover, BorderLayout.SOUTH);

        // adicionar os componentes
        add(painelEsquerda); // colocado na coluna 0
        add(painelDireita); // colocado na coluna 1
    }
}
