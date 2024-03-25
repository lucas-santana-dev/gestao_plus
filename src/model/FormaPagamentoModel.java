package model;

public class FormaPagamentoModel {

    // Enum para representar os tipos de forma de pagamento
    public enum TipoPagamento {
        AVISTA,
        CARTAO_CREDITO,
        CARTAO_DEBITO,
        CREDIARIO
    }

    private TipoPagamento tipoPagamento;
    private int parcelas; // Número de parcelas para pagamento com cartão de crédito

    // Construtor padrão
    public FormaPagamentoModel() {
    }

    // Construtor com todos os parâmetros
    public FormaPagamentoModel(TipoPagamento tipoPagamento, String numeroCartao, String bandeiraCartao, int parcelas, float valorTotal) {
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }

    // Métodos Get e Set
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

}
