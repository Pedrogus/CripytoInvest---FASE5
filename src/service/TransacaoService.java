package service;

import java.util.List;

import repository.TransacaoRepository;
import models.Transacao;

public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<Transacao> obterTransacoesPorCarteira(Long carteiraId) {
        return transacaoRepository.buscarPorCarteira(carteiraId);
    }

    public Transacao registrarTransacao(Transacao transacao) {
        return transacaoRepository.salvar(transacao);
    }
}
