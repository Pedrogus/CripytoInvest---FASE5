package controllers;

import java.util.List;

import models.Empresa;
import service.EmpresaService;

public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService)  {
        this.empresaService = empresaService;
    }

    public List<Empresa> listaEmpresas() {
        return empresaService.listarEmpresas();
    }
}
