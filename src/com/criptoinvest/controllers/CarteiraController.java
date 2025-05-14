package com.criptoinvest.controllers;

import com.criptoinvest.service.CarteiraService;

public class CarteiraController {
    private CarteiraService carteiraService;

    // Construtor para injetar a dependência do CarteiraService
    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }


}
