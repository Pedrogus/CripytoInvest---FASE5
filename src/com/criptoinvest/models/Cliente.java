package com.criptoinvest.models;

public class Cliente extends Usuario {

    private Carteira carteira;

    public Cliente() {}

    public Cliente(Long id, String nome, String email, String senha, String role) {
        super(id,nome,email,senha,role);
        this.carteira = new Carteira();
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void adicionarSaldoCarteira(double saldo) {
        this.carteira.setSaldo(saldo);
    }

    public double getSaldoCarteira() {
        return this.carteira.getSaldo();
    }

    public void exibirDados() { System.out.println("Cliente" + getNome());
            carteira.exibirSaldo();}

}

