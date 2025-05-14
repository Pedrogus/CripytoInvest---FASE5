package com.criptoinvest.service;

import java.util.List;

import com.criptoinvest.models.Empresa;
import com.criptoinvest.repository.EmpresaRepository;

public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.buscarTodas();
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.salvar(empresa);
    }
}
