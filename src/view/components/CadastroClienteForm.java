package view.components;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
                System.out.println("Nome: " + getNome());
                System.out.println("CPF: " + getCPF());
                System.out.println("RG: " + getRG());
                System.out.println("Data de Nascimento: " + getDataNascimento());
                System.out.println("Limite de Crédito: " + getLimiteCredito());
            }
        });
        add(submitButton, gbc);
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

    private NumberFormatter createDoubleFormatter() {
        java.text.NumberFormat format = java.text.NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return new javax.swing.text.NumberFormatter(format);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getCPF() {
        return cpfField.getText().replaceAll("[^0-9]", "");
    }

    public String getRG() {
        return rgField.getText().replaceAll("[^0-9]", "");
    }

    public String getDataNascimento() {
        return dataNascimentoField.getText();
    }

    public double getLimiteCredito() {
        try {
            return ((Number) limiteCreditoField.getValue()).doubleValue();
        } catch (NullPointerException e) {
            return 0.0;
        }
    }
}
