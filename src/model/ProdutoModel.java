package model;

import java.time.LocalDate;
import java.util.Date;

public class ProdutoModel {

    private long id;
    private String nomeProduto;
    private String tipoProduto;
    private float precoCompra;
    private float precoVenda;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private double estoque;

    //Construtor Padrão
    public ProdutoModel(){

    }

    //Construtor com parametros
    public ProdutoModel(
            long id,
            String nomeProduto,
            String tipoProduto,
            float precoCompra,
            float precoVenda,
            LocalDate dataFabricacao,
            LocalDate dataValidade,
            double estoque) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.estoque = estoque;
    }

    //Metodos
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
