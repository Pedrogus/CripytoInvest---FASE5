package com.criptoinvest.controllers;

import java.util.List;

import com.criptoinvest.models.Empresa;
import com.criptoinvest.service.EmpresaService;

public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService)  {
        this.empresaService = empresaService;
    }

    public List<Empresa> listaEmpresas() {
        return empresaService.listarEmpresas();
    }
}
