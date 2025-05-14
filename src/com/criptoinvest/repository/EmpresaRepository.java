package com.criptoinvest.repository;
import java.util.List;

import com.criptoinvest.models.Empresa;

public interface EmpresaRepository {
    List<Empresa> buscarTodas();
    Empresa salvar(Empresa empresa);
}
