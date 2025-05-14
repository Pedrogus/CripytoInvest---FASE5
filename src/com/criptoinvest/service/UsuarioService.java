package com.criptoinvest.service;

import com.criptoinvest.models.Usuario;
import com.criptoinvest.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    public Usuario autenticar(String email, String senha) {
        // Agora usamos `orElse(null)` para extrair o usuário
        Usuario usuario = usuarioRepository.buscarPorEmail(email).orElse(null);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public Usuario buscarPorId(Long id) {
        // Se o usuário não existir, retornamos `null`
        return usuarioRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }
}
