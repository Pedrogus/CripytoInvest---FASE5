package service;

import java.util.List;

import repository.CarteiraRepository;
import models.Carteira;

public class CarteiraService {
    private CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public Carteira buscarPorId(Long id) {
        return carteiraRepository.buscarPorId(id).orElse(null);  // Retorna null se não encontrar
    }

}
