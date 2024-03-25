import controller.ClienteController;
import model.ClienteModel;
import view.frames.mainframe.MainFrame;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando e exibindo a janela principal
        javax.swing.SwingUtilities.invokeLater(MainFrame::new);
    }
}