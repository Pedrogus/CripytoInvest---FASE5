package repository;

import java.util.List;
import models.Carteira;
import java.util.Optional;

public interface CarteiraRepository {
	Optional<Carteira> buscarPorId(Long id);
    List<Carteira> buscarPorUsuario(Long usuarioId);
    Carteira salvar(Carteira carteira);
 
}
