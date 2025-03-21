package controllers;

import models.Carteira;
import service.CarteiraService;
import java.util.Optional;

public class CarteiraController {
    private CarteiraService carteiraService;

    // Construtor para injetar a dependência do CarteiraService
    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }


}
