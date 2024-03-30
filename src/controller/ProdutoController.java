package controller;

import dao.ProdutoDAO;
import model.ProdutoModel;

import java.util.List;


public class ProdutoController {

    public static boolean salvarProduto(ProdutoModel novoProduto){
        novoProduto.setId(gerarNovoId());
        return ProdutoDAO.salvarProduto(novoProduto);
    }

    public static List<ProdutoModel> carregarTodosProdutos(){return ProdutoDAO.carregarProdutos();}

    private static long gerarNovoId() {
        List<ProdutoModel> produtos = ProdutoDAO.carregarProdutos();
        long ultimoId = 0;

        for (ProdutoModel produto : produtos) {
            if (produto.getId() > ultimoId) {
                ultimoId = produto.getId();
            }
        }
        return ultimoId + 1;
    }
}
