package main.view.frames.mainframe;

import main.util.SetSizeRelativeToScreen;
import main.view.frames.produtos.CadastroProdutoForm;
import main.view.frames.produtos.ListagemProdutosPanel;
import main.view.frames.venda.ResumoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final MainPanel mainPanel = new MainPanel();
    private final JPanel mainContent = new JPanel();
    private final ResumoPanel resumoPanel = new ResumoPanel();
    private final JPanel rightPanel = new JPanel();
    private final CadastroProdutoForm cadastroProduto = new CadastroProdutoForm();
    private final ListagemProdutosPanel listagemProdutosPanel = new ListagemProdutosPanel();
    private final SideBar sideBar = new SideBar();

    public MainFrame() {
        setTitle("SuperMarket - O App de gestão para seu negócio");
        initializeUI();
    }

    private void initializeUI() {
        SetSizeRelativeToScreen.setSizeRelativeToScreen(this, 0.9, 0.9);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        add(sideBar, BorderLayout.WEST);

        // Adiciona o rightPanel ao lado direito (EAST)
        rightPanel.setPreferredSize(new Dimension(350, getHeight()));
        add(rightPanel, BorderLayout.EAST);

        // Adiciona o mainPanel ao centro do JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Configura o layout do mainPanel
        mainPanel.setLayout(new BorderLayout());

        // Adiciona o mainContent ao mainPanel no centro
        mainPanel.add(mainContent, BorderLayout.CENTER);


        sideBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "NovaVenda":
                        mainContent.removeAll();
                        mainContent.setLayout(new BorderLayout());
                        mainContent.add(resumoPanel, BorderLayout.CENTER);
                        mainContent.revalidate();
                        mainContent.repaint();
                        break;
                    case "Produtos":
                        mainContent.removeAll();
                        rightPanel.removeAll();
                        rightPanel.add(cadastroProduto, BorderLayout.EAST);
                        rightPanel.revalidate();
                        rightPanel.repaint();
                        mainContent.setLayout(new BorderLayout());
                        mainContent.add(listagemProdutosPanel, BorderLayout.CENTER);
                        mainContent.revalidate();
                        mainContent.repaint();
                        break;
                    case "Clientes":
                        mainContent.removeAll();
                        mainContent.setLayout(new BorderLayout());
                        //  mainContent.add(resumoPanel, BorderLayout.CENTER);
                        mainContent.revalidate();
                        mainContent.repaint();
                        break;
                    case "Estoque":
                        mainContent.removeAll();
                        mainContent.setLayout(new BorderLayout());
                        //  mainContent.add(resumoPanel, BorderLayout.CENTER);
                        mainContent.revalidate();
                        mainContent.repaint();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
