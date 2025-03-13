package repository;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario salvar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }
}
