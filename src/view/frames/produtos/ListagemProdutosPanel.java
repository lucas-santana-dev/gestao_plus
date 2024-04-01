package view.frames.produtos;

import controller.ProdutoController;
import model.ProdutoModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemProdutosPanel extends JPanel {

    private JTable table;

    public ListagemProdutosPanel() {
        setLayout(new BorderLayout());

        List<ProdutoModel> produtos = ProdutoController.carregarTodosProdutos();
        Object[][] data = new Object[produtos.size()][8];

        for (int i = 0; i < produtos.size(); i++) {
            ProdutoModel produto = produtos.get(i);

            data[i][0] = produto.getId();
            data[i][1] = produto.getNomeProduto();
            data[i][2] = produto.getTipoProduto();
            data[i][3] = produto.getDataFabricacao();
            data[i][4] = produto.getDataValidade();
            data[i][5] = produto.getEstoque();
            data[i][6] = produto.getPrecoCompra();
            data[i][7] = produto.getPrecoVenda();

        }
        String[] columnNames = {"Codigo do Produto", "Nome do produto", "Tipo do Produto",
                "Data de Fabricação", "Data de Validade", "Estoque", "Preço de Compra", "Precço de Venda"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retorna false para todas as células, tornando a tabela não editável
                return false;
            }
        };
        table = new JTable(model);
        JScrollPane scrollPane =new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

    }
}
