package view.frames.clientes;

import controller.ClienteController;
import model.ClienteModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemClientesPanel extends JPanel {

    private JTable table; // Declaração da tabela como um campo de classe

    public ListagemClientesPanel() {
        setLayout(new BorderLayout());

        List<ClienteModel> clientes = ClienteController.carregarTodosClientes();

        Object[][] data = new Object[clientes.size()][6];

        for (int i = 0; i < clientes.size(); i++) {
            ClienteModel cliente = clientes.get(i);
            data[i][0] = cliente.getId();
            data[i][1] = cliente.getNome();
            data[i][2] = cliente.getCpf();
            data[i][3] = cliente.getRg();
            data[i][4] = cliente.getDataNascimento();
            data[i][5] = cliente.getLimiteCred();
        }

        String[] columnNames = {"Codigo do Cliente", "Nome", "CPF", "RG", "Data de Nascimento", "Limite de Crédito"};

        // Criar um modelo de tabela não editável
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retorna false para todas as células, tornando a tabela não editável
                return false;
            }
        };

        // Criando a tabela com o modelo personalizado
        table = new JTable(model); // Atribuição da tabela ao campo de classe

        // Adicionando a tabela em um JScrollPane e adicionando ao painel
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    //TODO: Ver porque não funciona
    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<ClienteModel> clientes = ClienteController.carregarTodosClientes();

        for (ClienteModel cliente : clientes) {
            Object[] rowData = {
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getCpf(),
                    cliente.getRg(),
                    cliente.getDataNascimento(),
                    cliente.getLimiteCred()
            };
            model.addRow(rowData); // Adiciona uma nova linha com os dados do cliente
        }
    }
}
