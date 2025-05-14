package com.criptoinvest.repository;

import com.criptoinvest.models.Transacao;
import com.criptoinvest.models.Carteira;

import java.util.List;

public interface TransacaoRepository  {
    Transacao salvar(Transacao transacao);
    List<Transacao> findByCarteira(Carteira carteira);
}
