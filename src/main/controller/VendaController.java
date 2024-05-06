package main.controller;

import main.dao.VendaDAO;
import main.model.VendaModel;

public class VendaController {

    public static boolean salvarNovaVenda(VendaModel novaVenda) {
        return VendaDAO.salvarVenda(novaVenda);
    }
}
