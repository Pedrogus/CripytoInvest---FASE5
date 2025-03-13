package service;

import java.util.List;

import repository.CarteiraRepository;
import models.Carteira;

public class CarteiraService {
    private CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public List<Carteira> obterCarteirasDoUsuario(Long usuarioId) {
        return carteiraRepository.buscarPorUsuario(usuarioId);
    }

    public Carteira criarCarteira(Carteira carteira) {
        return carteiraRepository.salvar(carteira);
    }
}
