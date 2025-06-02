package com.criptoinvest.repository;

import java.util.List;
import java.util.Optional;

import com.criptoinvest.models.Usuario;

public interface usuarioRepositoryInterface<T extends Usuario> {
    T salvar(T usuario);
    Optional<T> buscarPorEmail(String email);
    Optional<T> buscarPorId(Long id);
    List<T> listarUsuarios();
}
