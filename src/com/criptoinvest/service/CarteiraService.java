package com.criptoinvest.service;

import com.criptoinvest.repository.CarteiraRepository;
import com.criptoinvest.models.Carteira;
import java.util.Optional;

public class CarteiraService {
    private final CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public void adicionarFundo(Carteira carteira, double valor) {
        if (valor <= 0) {throw new IllegalArgumentException("O valor a ser retirado deve ser positivo.");}

        carteira.setSaldo(carteira.getSaldo() + valor);
        carteiraRepository.salvar(carteira);
        System.out.println("R$ " + valor + " adicionados à carteira ID: " + carteira.getId());
    }


    public void retirarFundo(Carteira carteira, double valor) {
        if (valor <= 0) {throw new IllegalArgumentException("O valor a ser retirado deve ser positivo.");}

        if (carteira.getSaldo() < valor) {throw new IllegalArgumentException("Saldo insuficiente.");}

        carteira.setSaldo(carteira.getSaldo() - valor);
        carteiraRepository.salvar(carteira);
        System.out.println("R$ " + valor + " retirado da carteira ID: " + carteira.getId());
    }

    public Optional<Carteira> buscarPorId(Long id) {
        return carteiraRepository.buscarPorId(id);
    }

}
