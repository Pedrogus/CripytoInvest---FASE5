package repository;

import java.util.List;
import models.Carteira;

public interface CarteiraRepository {
    List<Carteira> buscarPorUsuario(Long usuarioId);
    Carteira salvar(Carteira carteira);
}
