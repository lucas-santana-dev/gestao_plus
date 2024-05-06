import main.view.frames.mainframe.MainFrame;

import static main.dao.ClienteDAO.criarClienteConsumidorFinalSeVazio;

public class Main {
    public static void main(String[] args) {
        // Criando e exibindo a janela principal
        criarClienteConsumidorFinalSeVazio();
        javax.swing.SwingUtilities.invokeLater(MainFrame::new);
    }
}