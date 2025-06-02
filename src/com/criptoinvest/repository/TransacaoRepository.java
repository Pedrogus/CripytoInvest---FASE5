
package com.criptoinvest.repository;

import com.criptoinvest.models.Transacao;
import com.criptoinvest.models.Carteira;
import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository implements TransacaoRepositoryInterface {
    private List<Transacao> transacoes = new ArrayList<>();

    @Override
    public Transacao salvar(Transacao transacao) {
        transacoes.add(transacao);
        return transacao;
    }

   @Override
    public List<Transacao> findByCarteira(Carteira carteira) {
        List<Transacao> resultado = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getCarteira().equals(carteira)) {
                resultado.add(transacao);
            }
        }
        return resultado;
    }
}
