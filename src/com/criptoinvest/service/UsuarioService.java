package com.criptoinvest.service;

import com.criptoinvest.models.Usuario;
import com.criptoinvest.repository.usuarioRepositoryInterface;

import java.util.List;

public class UsuarioService {
    private usuarioRepositoryInterface usuarioRepositoryInterface;

    public UsuarioService(usuarioRepositoryInterface usuarioRepositoryInterface) {
        this.usuarioRepositoryInterface = usuarioRepositoryInterface;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositoryInterface.salvar(usuario);
    }

    public Usuario autenticar(String email, String senha) {
        // Agora usamos `orElse(null)` para extrair o usuário
        Usuario usuario = usuarioRepositoryInterface.buscarPorEmail(email).orElse(null);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public Usuario buscarPorId(Long id) {
        // Se o usuário não existir, retornamos `null`
        return usuarioRepositoryInterface.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositoryInterface.listarUsuarios();
    }
}
