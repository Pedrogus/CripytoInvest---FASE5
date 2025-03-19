package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import models.Usuario;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorId(Long id);
    List<Usuario> listarUsuarios();
}
