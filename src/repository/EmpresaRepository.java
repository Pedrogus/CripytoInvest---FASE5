package repository;
import java.util.List;

import models.Empresa;

public interface EmpresaRepository {
    List<Empresa> buscarTodas();
    Empresa salvar(Empresa empresa);
}
