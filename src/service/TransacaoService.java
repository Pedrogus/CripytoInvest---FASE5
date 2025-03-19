package service;

import java.util.List;

import repository.TransacaoRepository;
import models.Transacao;

public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.salvar(transacao);  // Salva a transação no repositório
    }
}
