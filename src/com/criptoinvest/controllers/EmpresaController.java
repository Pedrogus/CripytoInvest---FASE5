package com.criptoinvest.controllers;

import java.util.List;

import com.criptoinvest.models.Empresa;
import com.criptoinvest.service.EmpresaService;

public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public List<Empresa> listaEmpresas() {

        List<Empresa> empresas = empresaService.listarEmpresas();

        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa encontrada.");
        } else {
            for (Empresa empresa : empresas) {
                System.out.println(empresa);
            }
        }
        return empresas;
    }

}
