
package repository;

import models.Transacao;
import models.Carteira;
import java.util.ArrayList;
import java.util.List;

public class TransacaoRepositoryImpl implements TransacaoRepository {
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
