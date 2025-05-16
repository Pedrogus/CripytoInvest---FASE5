package com.criptoinvest.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.criptoinvest.models.Cliente;
import com.criptoinvest.models.Empresa;
import com.criptoinvest.repository.UsuarioRepository;
import com.criptoinvest.service.TransacaoService;
import com.criptoinvest.service.UsuarioService;
import com.criptoinvest.models.Usuario;

public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    public Usuario obterDadosUsuario(Long id) {
        return usuarioService.buscarPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    public Usuario criarUsuario(Scanner scanner) {
        try {
            String nome = lerEntrada(scanner, "Nome do usuario: ");
            String email = lerEntrada(scanner, "Email do usuario: ");
            String senha = lerEntrada(scanner, "Senha do usuario: ");

            String role = lerEntrada(scanner, "Role (CLIENTE / EMPRESA): ").toUpperCase();

            Usuario usuario;
            if (role.equals("CLIENTE")) {
                String cpf = lerEntrada(scanner, "CPF: ");
                usuario = new Cliente((long) (Math.random() * 1000), nome, email, senha, "Cliente", cpf);
            } else if (role.equals("EMPRESA")) {
                String setor = lerEntrada(scanner, "Setor da Empresa: ");
                String cnpj = lerEntrada(scanner, "CNPJ: ");
                usuario = new Empresa((long) (Math.random() * 1000), nome, email, senha, setor, cnpj);
            } else {
                throw new IllegalArgumentException("Role inválido!. Use CLIENTE or EMPRESA.");
            }

            usuarioRepository.salvar(usuario);
            System.out.println("Usuario criada com sucesso! ID: " + usuario.getId());
            return usuario;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        return null;
    }

    private String lerEntrada(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine().trim();
        if(entrada.isEmpty()){
            throw new  IllegalArgumentException(mensagem.trim() + "não pode estar vazio!");
        }
        return entrada;
    }
}
