package view.frames.clientes;

import controller.ClienteController;
import model.ClienteModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroClienteForm extends JPanel {
    private JTextField nomeField;
    private JFormattedTextField cpfField;
    private JFormattedTextField rgField;
    private JFormattedTextField dataNascimentoField;
    private JFormattedTextField limiteCreditoField;

    public CadastroClienteForm() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Nome:"), gbc);

        gbc.gridx++;

        nomeField = new JTextField(20);
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        add(new JLabel("CPF:"), gbc);

        gbc.gridx++;

        cpfField = createFormattedTextField("###.###.###-##");
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        add(new JLabel("RG:"), gbc);
        gbc.gridx++;
        rgField = createFormattedTextField("##.###.###-##");
        rgField.setColumns(10); //TODO Verificar com professor o motivo de que quando o valor ultrapassa 10 acontece o erro do parce
        add(rgField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Data de Nascimento (DD/MM/AAAA):"), gbc);
        gbc.gridx++;
        dataNascimentoField = createFormattedTextField("##/##/####");
        add(dataNascimentoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Limite de Crédito:"), gbc);
        gbc.gridx++;
        limiteCreditoField = new JFormattedTextField(createDoubleFormatter());
        limiteCreditoField.setColumns(15);
        add(limiteCreditoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Cadastrar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteModel novoCliente = new ClienteModel();
                novoCliente.setId(1);
                novoCliente.setNome(nomeField.getText().trim().toUpperCase());
                novoCliente.setCpf(cpfField.getText());
                novoCliente.setRg(convertToInt(rgField));
                try {
                    novoCliente.setDataNascimento(ConvertToLocalDate(dataNascimentoField));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    novoCliente.setLimiteCred(ConvertToBigDecimal(limiteCreditoField));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                boolean clienteSalvoComSucesso = ClienteController.salvarNovoCliente(novoCliente);
                if (clienteSalvoComSucesso) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    // Limpa os campos após o sucesso do cadastro
                    nomeField.setText("");
                    cpfField.setText("");
                    rgField.setText("");
                    dataNascimentoField.setText("");
                    limiteCreditoField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar o cliente. Por favor, tente novamente.");
                }
            }
        });
        add(submitButton, gbc);
    }
    private int convertToInt(JFormattedTextField textField) {
        String rgText = textField.getText().trim();
        rgText = rgText.replaceAll("[^0-9]", ""); // Remove todos os caracteres que não são dígitos
        return Integer.parseInt(rgText); // Converte a string limpa para um número inteiro
    }

    private JFormattedTextField createFormattedTextField(String mask) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
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
