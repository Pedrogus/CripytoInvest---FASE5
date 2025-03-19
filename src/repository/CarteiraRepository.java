package repository;

import java.util.List;
import models.Carteira;
import java.util.Optional;

public interface CarteiraRepository {
    List<Carteira> buscarPorUsuario(Long usuarioId);
    Carteira salvar(Carteira carteira);
    Optional<Carteira> buscarPorId(Long id);
}
