package com.criptoinvest.service;

import com.criptoinvest.repository.TransacaoRepositoryInterface;
import com.criptoinvest.models.Transacao;

public class TransacaoService {
    private TransacaoRepositoryInterface transacaoRepositoryInterface;

    public TransacaoService(TransacaoRepositoryInterface transacaoRepositoryInterface) {
        this.transacaoRepositoryInterface = transacaoRepositoryInterface;
    }

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepositoryInterface.salvar(transacao);  // Salva a transação no repositório
    }
}
