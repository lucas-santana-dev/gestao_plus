package controller;

import dao.ClienteDAO;
import model.ClienteModel;

import java.util.List;

public class ClienteController {

    // Método para salvar um novo cliente
    public static void salvarNovoCliente(ClienteModel novoCliente) {
        // Aqui você pode implementar lógica para gerar um novo ID, se necessário
        novoCliente.setId(gerarNovoId());

        ClienteDAO.salvarCliente(novoCliente);
    }

    // Método para carregar todos os clientes
    public static List<ClienteModel> carregarTodosClientes() {
        return ClienteDAO.carregarClientes();
    }

    // Método privado para gerar um novo ID de cliente
    private static long gerarNovoId() {
        List<ClienteModel> clientes = ClienteDAO.carregarClientes();
        long ultimoId = 0;

        // Encontrar o maior ID entre os clientes existentes
        for (ClienteModel cliente : clientes) {
            if (cliente.getId() > ultimoId) {
                ultimoId = cliente.getId();
            }
        }

        // Incrementar o último ID para obter um novo ID único
        return ultimoId + 1;
    }

}
