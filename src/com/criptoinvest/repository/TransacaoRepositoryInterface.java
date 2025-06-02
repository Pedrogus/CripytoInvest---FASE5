package com.criptoinvest.repository;

import com.criptoinvest.models.Transacao;
import com.criptoinvest.models.Carteira;

import java.util.List;

public interface TransacaoRepositoryInterface {
    Transacao salvar(Transacao transacao);
    List<Transacao> findByCarteira(Carteira carteira);
}
