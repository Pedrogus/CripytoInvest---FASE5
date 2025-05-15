package com.criptoinvest.models;

public class Cliente extends Usuario {

    private Carteira carteira;
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String senha, String role, String cpf) {
        super(id, nome, email, senha, role);
        this.carteira = new Carteira();
        this.cpf = cpf;
    }

    public Carteira getCarteira() {
        return carteira;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                '}';
    }
}

