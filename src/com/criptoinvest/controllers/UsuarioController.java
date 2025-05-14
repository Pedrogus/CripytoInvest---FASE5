package com.criptoinvest.controllers;

import java.util.List;

import com.criptoinvest.service.UsuarioService;
import com.criptoinvest.models.Usuario;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario obterDadosUsuario(Long id) {
        return usuarioService.buscarPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
