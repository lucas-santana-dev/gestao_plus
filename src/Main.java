import main.view.frames.login.LoginFrame;

import static main.dao.ClienteDAO.criarClienteConsumidorFinalSeVazio;

public class Main {
    public static void main(String[] args) {
        // Criando e exibindo a janela principal
        criarClienteConsumidorFinalSeVazio();
        javax.swing.SwingUtilities.invokeLater(LoginFrame::new);
    }
}