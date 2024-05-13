package main.view.frames.produtos;

import main.controller.ProdutoController;
import main.model.ProdutoModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class CadastroProdutoForm extends JPanel {

    // Campos de texto e componentes de seleção de data
    private final JTextField nomeProdutoField;
    private final JTextField tipoProdutoField;
    private final JFormattedTextField precoCompra;
    private final JFormattedTextField precoVenda;
    private final JDatePickerImpl dataFabricacaoPicker;
    private final JDatePickerImpl dataValidadePicker;
    private final JFormattedTextField estoque;

    public CadastroProdutoForm() {
        setPreferredSize(new Dimension(350, 500)); // Define o tamanho preferido do JPanel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Esquema de layout vertical

        // Inicializa os componentes
        nomeProdutoField = new JTextField(20);
        tipoProdutoField = new JTextField(20);
        precoCompra = createFormattedTextField();
        precoVenda = createFormattedTextField();
        dataFabricacaoPicker = createDatePicker();
        dataValidadePicker = createDatePicker();
        estoque = createFormattedTextField();

        // Adiciona os campos ao formulário
        addField("Nome do Produto:", nomeProdutoField);
        addField("Tipo do Produto:", tipoProdutoField);
        addField("Preço de Compra:", precoCompra);
        addField("Preço de Venda:", precoVenda);
        addField("Data de Fabricação:", dataFabricacaoPicker);
        addField("Data de Validade:", dataValidadePicker);
        addField("Estoque:", estoque);

        // Botão de cadastro
        JButton submitButton = new JButton("Cadastrar");
        submitButton.addActionListener((e) -> cadastrarProduto());
        add(submitButton);
    }

    // Método para adicionar um campo ao formulário
    private void addField(String label, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(field);
        add(panel);
    }

    // Método para criar um campo de texto formatado para números
    private JFormattedTextField createFormattedTextField() {
        JFormattedTextField textField = new JFormattedTextField(createDoubleFormatter());
        textField.setColumns(15);
        return textField;
    }

    // Método para criar um seletor de data
    private JDatePickerImpl createDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hoje");
        properties.put("text.month", "Mês");
        properties.put("text.year", "Ano");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    // Método para formatar números como moeda
    private NumberFormatter createDoubleFormatter() {
        DecimalFormat format = new DecimalFormat("#,##0.00");
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(BigDecimal.class);
        formatter.setAllowsInvalid(false);
        return formatter;
    }

    // Método para cadastrar o produto
    private void cadastrarProduto() {
        ProdutoModel produto = new ProdutoModel();
        produto.setId(1);
        produto.setNomeProduto(nomeProdutoField.getText().trim().toUpperCase());
        produto.setTipoProduto(tipoProdutoField.getText().trim().toUpperCase());
        try {
            produto.setPrecoCompra((BigDecimal) precoCompra.getValue());
            produto.setPrecoVenda((BigDecimal) precoVenda.getValue());
            produto.setDataFabricacao(convertToLocalDate(dataFabricacaoPicker));
            produto.setDataValidade(convertToLocalDate(dataValidadePicker));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        try {
            double estoqueValue = Double.parseDouble(estoque.getText().replaceAll(",", "."));
            // Agora você pode usar o valor de estoqueValue conforme necessário
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido para o estoque.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        boolean produtoSalvoComSucesso = ProdutoController.salvarProduto(produto);
        if (produtoSalvoComSucesso) {
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar o produto. Por favor, tente novamente!");
        }
    }

    // Método para limpar os campos do formulário
    private void clearFields() {
        nomeProdutoField.setText("");
        tipoProdutoField.setText("");
        precoCompra.setValue(null);
        precoVenda.setValue(null);
        dataFabricacaoPicker.getModel().setValue(null);
        dataValidadePicker.getModel().setValue(null);
        estoque.setText("");
    }

    // Método para converter um seletor de data em LocalDate
    private LocalDate convertToLocalDate(JDatePickerImpl datePicker) throws ParseException {
        Date selectedDate = (Date) datePicker.getModel().getValue();
        return selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // Classe auxiliar para formatar a exibição da data no JDatePicker
    static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final String datePattern = "dd/MM/yyyy";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                return dateFormatter.format(value);
            }
            return "";
        }
    }
}
