package service;

import java.util.List;

import repository.CarteiraRepository;
import models.Carteira;
import java.util.Optional;

public class CarteiraService {
    private final CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public void adicionarFundo(Carteira carteira, double valor) {
        if (valor > 0) {
            carteira.setSaldo(carteira.getSaldo() + valor);
            carteiraRepository.salvar(carteira);
            System.out.println("R$ " + valor + " adicionados à carteira ID: " + carteira.getId());
        } else {
            System.out.println("O valor a ser adicionado deve ser positivo.");
        }
    }

    public Optional<Carteira> buscarPorId(Long id) {
        return carteiraRepository.buscarPorId(id);
    }

}
