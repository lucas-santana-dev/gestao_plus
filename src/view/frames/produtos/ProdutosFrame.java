package view.frames.produtos;

import util.SetSizeRelativeToScreen;

import javax.swing.*;

public class ProdutosFrame extends JFrame {

    private JTabbedPane tabbedPane = new JTabbedPane();

    private CadastroProdutoForm cadastroProdutoForm = new CadastroProdutoForm();

    private ListagemProdutosPanel listageDeProdutos = new ListagemProdutosPanel();

   // private final ListagemProdutosPanel listagemProdutosPanel = new ListagemProdutosPanel();
    public ProdutosFrame(){initializeUI();}

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this,0.7,0.7);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Produtos");
        add(tabbedPane);

        tabbedPane.addTab("Cadastro de Produto", cadastroProdutoForm);
        tabbedPane.add("Listagem de Produtos",listageDeProdutos);

        setVisible(true);
    }

}
