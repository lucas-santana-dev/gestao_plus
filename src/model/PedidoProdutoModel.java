package model;

public class PedidoProdutoModel extends ProdutoModel {

    private double quantidadeEntrada;

    // Construtor padrão
    public PedidoProdutoModel() {
        // Chama o construtor padrão da superclasse ProdutoModel
        super();
    }

    // Construtor com parâmetros
    public PedidoProdutoModel(double quantidadeEntrada) {
        // Chama o construtor da superclasse ProdutoModel que recebe parâmetros
        super();
        this.quantidadeEntrada = quantidadeEntrada;
    }

    // Métodos Get e Set específicos para quantidadeEntrada
    public double getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(double quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }
}
