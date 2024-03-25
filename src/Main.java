import controller.ClienteController;
import model.ClienteModel;
import view.frames.mainframe.MainFrame;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criando e exibindo a janela principal
        javax.swing.SwingUtilities.invokeLater(MainFrame::new);

        // Criando um novo cliente
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setId(1); // Defina o ID conforme necessário
        novoCliente.setNome("João Silva");
        novoCliente.setCpf("123.456.789-00"); // Lembrando que você deve ajustar para o formato adequado
        novoCliente.setRg(1234567); // Defina o RG conforme necessário
        novoCliente.setDataNascimento(LocalDate.of(1990, 5, 15)); // Defina a data de nascimento conforme necessário
        novoCliente.setLimiteCred(new BigDecimal("5000.00"));
        ClienteController.salvarNovoCliente(novoCliente);

    }
}