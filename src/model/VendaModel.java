package model;

import java.util.ArrayList;
import java.util.List;

public class VendaModel {

    private ClienteModel cliente;
    private List<ProdutoModel> produtos;
    private FormaPagamentoModel formaPagamento;
    private float valorCompra; // Valor total da compra

    // Construtor padrão
    public VendaModel() {
        produtos = new ArrayList<>();
    }

    // Construtor com todos os parâmetros
    public VendaModel(ClienteModel cliente, List<ProdutoModel> produtos, FormaPagamentoModel formaPagamento, float valorCompra) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.valorCompra = valorCompra;
    }

    // Métodos Get e Set
    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModel> produtos) {
        this.produtos = produtos;
    }

    public FormaPagamentoModel getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoModel formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
}
