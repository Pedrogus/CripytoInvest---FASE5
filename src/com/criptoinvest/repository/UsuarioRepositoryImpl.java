package com.criptoinvest.repository;

import com.criptoinvest.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl<T extends Usuario> implements UsuarioRepository<T> {
    private List<T> usuarios = new ArrayList<>();

    @Override
    public T salvar(T usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Optional<T> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<T> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
