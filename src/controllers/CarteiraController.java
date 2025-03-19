package controllers;

import models.Carteira;
import service.CarteiraService;

public class CarteiraController {
    private CarteiraService carteiraService;

    // Construtor para injetar a dependência do CarteiraService
    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }


    public Carteira visualizarCarteira(Long id) {
        return carteiraService.buscarPorId(id);
    }
}
