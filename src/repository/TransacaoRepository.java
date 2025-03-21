package repository;

import models.Transacao;
import models.Carteira;

import java.util.List;

public interface TransacaoRepository  {
    Transacao salvar(Transacao transacao);
    List<Transacao> findByCarteira(Carteira carteira);
}
