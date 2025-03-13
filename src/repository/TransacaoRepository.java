package repository;

import models.Transacao;

import java.util.List;

public interface TransacaoRepository  {
    List<Transacao> buscarPorCarteira(Long carteiraId);
    Transacao salvar(Transacao transacao);
}
