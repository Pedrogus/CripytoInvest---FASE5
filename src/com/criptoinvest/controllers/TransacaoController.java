package com.criptoinvest.controllers;

import com.criptoinvest.models.Transacao;
import com.criptoinvest.service.TransacaoService;

public class TransacaoController {
    private TransacaoService transacaoService;

    // Construtor para injetar a dependência do TransacaoService
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    // Método para criar uma transação
    public Transacao criarTransacao(Transacao transacao) {
        return transacaoService.criarTransacao(transacao);  // Chama o método no serviço
    }
}
