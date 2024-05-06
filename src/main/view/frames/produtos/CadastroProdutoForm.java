package main.view.frames.produtos;

import main.controller.ProdutoController;
import main.model.ProdutoModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroProdutoForm extends JPanel {

    private final JTextField nomeProdutoField;
    private final JTextField tipoProdutoField;
    private final JFormattedTextField precoCompra;
    private final JFormattedTextField precoVenda;
    private final JFormattedTextField dataFabricacao;
    private final JFormattedTextField dataValidade;
    private final JFormattedTextField estoque;

    public CadastroProdutoForm() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Nome do Produto:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        nomeProdutoField = new JTextField(50);
        add(nomeProdutoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Tipo do Produto:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        tipoProdutoField = new JTextField(50);
        add(tipoProdutoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Preço de Compra:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        precoCompra = new JFormattedTextField(createDoubleFormatter());
        precoCompra.setColumns(15);
        add(precoCompra, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Preço de Venda:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        precoVenda = new JFormattedTextField(createDoubleFormatter());
        precoVenda.setColumns(15);
        add(precoVenda, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Data de Fabricação (dd/MM/aaaa):"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        dataFabricacao = createFormattedTextField();
        add(dataFabricacao, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Data de Validade (dd/MM/aaaa):"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        dataValidade = createFormattedTextField();
        add(dataValidade, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        gbc.gridwidth = 1; // Resetando gridwidth para o padrão
        add(new JLabel("Estoque:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa o restante da linha
        estoque = new JFormattedTextField(createDoubleFormatter());
        estoque.setColumns(15);
        add(estoque, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Cadastrar");
        submitButton.addActionListener((e) -> {
            ProdutoModel produto = new ProdutoModel();
            produto.setId(1);
            produto.setNomeProduto(nomeProdutoField.getText().trim().toUpperCase());
            produto.setTipoProduto(tipoProdutoField.getText().trim().toUpperCase());
            try {
                produto.setPrecoCompra(ConvertToBigDecimal(precoCompra));
                produto.setPrecoVenda(ConvertToBigDecimal(precoVenda));
                produto.setDataFabricacao(ConvertToLocalDate(dataFabricacao));
                produto.setDataValidade(ConvertToLocalDate(dataValidade));
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            try {
                double estoqueValue = Double.parseDouble(estoque.getText().replaceAll(",", "."));
                // Agora você pode usar o valor de estoqueValue conforme necessário
            } catch (NumberFormatException ex) {
                // Lidar com a situação em que a entrada não é um número válido
                // Por exemplo, exibir uma mensagem de erro ao usuário
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido para o estoque.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            boolean produtoSalvoComSucesso = ProdutoController.salvarProduto(produto);
            if (produtoSalvoComSucesso) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                nomeProdutoField.setText("");
                tipoProdutoField.setText("");
                precoCompra.setText("");
                precoVenda.setText("");
                dataFabricacao.setText("");
                dataValidade.setText("");
                estoque.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar o produto. Por favor, tente novamente!");
            }

        });
        add(submitButton, gbc);
    }

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

    private BigDecimal ConvertToBigDecimal(JFormattedTextField textField) throws ParseException {
        String text = textField.getText();
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.setParseBigDecimal(true);
        return (BigDecimal) format.parse(text);
    }

    private LocalDate ConvertToLocalDate(JFormattedTextField textField) throws ParseException {
        String text = textField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(text, formatter);
    }

    private NumberFormatter createDoubleFormatter() {
        java.text.NumberFormat format = java.text.NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return new javax.swing.text.NumberFormatter(format);
    }
}
