package br.com.primeiroprojeto.pessoa.model;

import java.util.UUID;

public class Pessoa {
    private UUID id;
    private String nome;
    private String endereco;
    private String email;
    private String dataNascimento;

    public Pessoa() {
    }

    public Pessoa(UUID id, String nome, String endereco, String email, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
