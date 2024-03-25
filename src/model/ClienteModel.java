package model;

import java.util.Date;

public class ClienteModel {

    private long id;
    private String nome;
    private int cpf;
    private int rg;
    private Date data_nascimento;
    private float limite_cred;

    // Construtor padrão
    public ClienteModel() {
    }

    // Construtor com todos os parâmetros
    public ClienteModel(long id, String nome, int cpf, int rg, Date data_nascimento, float limite_cred) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.limite_cred = limite_cred;
    }

    // Métodos Get
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public float getLimite_cred() {
        return limite_cred;
    }

    // Métodos Set
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setLimite_cred(float limite_cred) {
        this.limite_cred = limite_cred;
    }
}
