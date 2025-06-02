package com.criptoinvest.repository;

import com.criptoinvest.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class usuarioRepository<T extends Usuario> implements usuarioRepositoryInterface<T> {
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
        List<T> listaUsuarios = new ArrayList<>(usuarios);
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuario encontrado");
        } else {
            for(T usuario : listaUsuarios) {
                System.out.println(usuario.toString());
            }
        }

        return listaUsuarios;
    }
}
