package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClienteModel {

    private long id;
    private String nome;
    private String cpf; // Alteração para representar CPF como String
    private int rg;
    private LocalDate dataNascimento; // Alteração para usar LocalDate em vez de Date
    private BigDecimal limiteCred; // Alteração para usar BigDecimal para representar limite de crédito

    // Construtor padrão
    public ClienteModel() {
    }

    // Construtor com todos os parâmetros
    public ClienteModel(long id, String nome, String cpf, int rg, LocalDate dataNascimento, BigDecimal limiteCred) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.limiteCred = limiteCred;
    }

    // Métodos Get
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getLimiteCred() {
        return limiteCred;
    }

    // Métodos Set
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setLimiteCred(BigDecimal limiteCred) {
        this.limiteCred = limiteCred;
    }
}
