package com.criptoinvest.service;

import com.criptoinvest.repository.TransacaoRepository;
import com.criptoinvest.models.Transacao;

public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.salvar(transacao);  // Salva a transação no repositório
    }
}
