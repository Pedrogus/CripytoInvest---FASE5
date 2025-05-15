package com.criptoinvest.repository;

import com.criptoinvest.models.Empresa;

import java.util.ArrayList;
import java.util.List;

public class EmpresaRepositoryImpl extends UsuarioRepositoryImpl<Empresa> implements EmpresaRepository {
    private List<Empresa> empresas = new ArrayList<>();


    @Override
    public List<Empresa> buscarTodas() {
        return super.listarUsuarios();
    }

    @Override
    public Empresa salvar(Empresa empresa) {
        empresas.add(empresa);
        return empresa;
    }
}
