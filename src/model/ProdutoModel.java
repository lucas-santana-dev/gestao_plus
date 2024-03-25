package model;

import java.util.Date;

public class ProdutoModel {

    private String nomeProduto;
    private String tipoProduto;
    private float precoCompra;
    private float precoVenda;
    private Date dataFabricacao;
    private Date dataValidade;
    private double estoque;

    //Construtor Padrão
    public ProdutoModel(){

    }

    //Construtor com parametros
    public ProdutoModel(
            String nomeProduto,
            String tipoProduto,
            float precoCompra,
            float precoVenda,
            Date ddtaFabricacao,
            Date dataValidade,
            double estoque) {
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.dataFabricacao = ddtaFabricacao;
        this.dataValidade = dataValidade;
        this.estoque = estoque;
    }

    //Metodos

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

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
