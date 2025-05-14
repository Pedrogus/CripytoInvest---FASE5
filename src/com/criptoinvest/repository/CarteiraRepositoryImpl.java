package com.criptoinvest.repository;

import com.criptoinvest.models.Carteira;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarteiraRepositoryImpl implements CarteiraRepository {
    private List<Carteira> carteiras = new ArrayList<>();

    @Override
    public Optional<Carteira> buscarPorId(Long id) {
        return carteiras.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Carteira> buscarPorUsuario(Long id) {
        List<Carteira> resultado = new ArrayList<>();
        for (Carteira carteira : carteiras) {
            if (carteira.getUsuario() != null && carteira.getUsuario().getId().equals(id)) {
                resultado.add(carteira);
            }
        }
        return resultado;
    }

    @Override
    public Carteira salvar(Carteira carteira) {
        carteiras.add(carteira);
        return carteira;
    }

    public void adicionarCarteira(Carteira carteira) {
        carteiras.add(carteira);
    }
}
