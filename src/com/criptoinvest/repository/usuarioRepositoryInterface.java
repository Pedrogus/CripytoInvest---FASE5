package com.criptoinvest.repository;

import java.util.List;
import java.util.Optional;

import com.criptoinvest.models.Usuario;

public interface usuarioRepositoryInterface {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorId(Long id);
    List<Usuario> listarUsuarios();
    boolean excluirUsuario(Long id);
    boolean atualizarUsuario(Usuario usuario);
}
