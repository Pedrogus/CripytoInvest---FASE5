package com.criptoinvest.models;

public class Carteira {
    private Long id;
    private Usuario usuario;
    private double saldo;
    public Long carteiraIdGerado = null;

    public Carteira() {
    }

    public Carteira(Long id, Usuario usuario, double saldo) {
        this.id = id;
        this.usuario = usuario;
        this.saldo = saldo;
    }



    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

