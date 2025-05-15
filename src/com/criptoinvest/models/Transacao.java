package com.criptoinvest.models;

import java.time.LocalDateTime;

public class Transacao {
    private Long id;
    private Carteira carteira;
    private String tipo;
    private double valor;
    private LocalDateTime data;

    public Transacao() {}

    public Transacao(Long id, Carteira carteira, String tipo, double valor, LocalDateTime data) {
        this.id = id;
        this.carteira = carteira;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }


    public void retirarSaldo(Carteira carteira, double valor) {
        if (valor > 0 && carteira.getSaldo() >= valor) {
            double novoSaldo = carteira.getSaldo() - valor;
            carteira.setSaldo(novoSaldo);
            System.out.println("Saldo retirado. Novo saldo: " + novoSaldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

}
