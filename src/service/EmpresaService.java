package service;

import java.util.List;

import models.Empresa;
import repository.EmpresaRepository;

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
