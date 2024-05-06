package main.view.frames.venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.controller.ProdutoController;
import main.model.ProdutoModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JTextField totalField;
    private float preco = 0;
    public float soma = 0;

    List<ProdutoModel> produtos = ProdutoController.carregarTodosProdutos();
    List<ProdutoModel> produtosSelecionados = new ArrayList<>();

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
        totalField = new JTextField();
        btnAdicionar = new JButton("Adicionar >>");
        btnAdicionar.addActionListener((ActionEvent e) -> {

            // usuário digita a quantidade de produtos
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));

            // obtém a lista de todos os produtos
            List<String> listProd = listaProdutos.getSelectedValuesList();

            // percorre toda a lista dos produtos
            for (int i = 0; i < listProd.size(); i++) {

                String produtoSelecionado = listProd.get(i);

                // compara o produto selecionado com a lista de produtos do database
                for (int j = 0; j < produtos.size(); j++) {
                    ProdutoModel produto = produtos.get(j); // obtém todos os produtos cadastrados
                    if (produto.getNomeProduto() == produtoSelecionado) {

                        produtosSelecionados.add(produto);

                        preco = quantidade * produto.getPrecoVenda().floatValue();

                        modeloTabela
                                .addRow(new Object[] { produto.getNomeProduto(), quantidade,
                                        preco });
                    }
                    modeloLista.removeElement(produtoSelecionado);
                }
            }

            // cálculo do preço total
            soma = soma + preco;

            totalField.setText("R$ " + soma);
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

            // estrutura de repetição para remover o produto da lista de compras
            for (int i = 0; i < produtosSelecionados.size(); i++) {

                if (tabelaCompra.getValueAt(linha, 0).toString() == produtosSelecionados.get(i).getNomeProduto()) {
                    produtosSelecionados.remove(i);
                }
            }

            // cálculo do preço total
            soma = soma - objectToFloat(tabelaCompra.getValueAt(linha, 2));

            totalField.setText("R$ " + soma);

            // remove o produto
            modeloTabela.removeRow(linha);

        });

        // configurar o layout da esquerda
        JPanel painelEsquerda = new JPanel(new BorderLayout());
        painelEsquerda.add(new Label("Produtos"), BorderLayout.NORTH);
        painelEsquerda.add(scrollPaneLista, BorderLayout.CENTER);
        painelEsquerda.add(btnAdicionar, BorderLayout.EAST);
        painelEsquerda.add(new Label("TOTAL"), BorderLayout.SOUTH);

        // configurar o layout da direita
        JPanel painelDireita = new JPanel(new BorderLayout());
        painelDireita.add(new Label("Compras"), BorderLayout.NORTH);
        painelDireita.add(scrollPaneTabela, BorderLayout.CENTER);
        painelDireita.add(btnRemover, BorderLayout.EAST);
        painelDireita.add(totalField, BorderLayout.SOUTH);

        // adicionar os componentes
        add(painelEsquerda); // colocado na coluna 0
        add(painelDireita); // colocado na coluna 1
    }

    // Método para converter um objeto para float
    private Float objectToFloat(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Float) {
            return (Float) o;
        }
        try {
            return Float.valueOf(o.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
