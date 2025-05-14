package com.criptoinvest.repository;

import com.criptoinvest.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario salvar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
