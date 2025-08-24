package com.criptoinvest.main;

import com.criptoinvest.controllers.*;
import com.criptoinvest.models.*;
import com.criptoinvest.repository.*;
import com.criptoinvest.service.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criando Models
        Carteira carteira = new Carteira();

        // Criando repositórios
        usuarioRepositoryInterface usuarioRepositoryInterface = new usuarioRepository();
        CarteiraRepositoryInterface carteiraRepositoryInterface = new CarteiraRepository();
        TransacaoRepositoryInterface transacaoRepositoryInterface = new TransacaoRepository();

        // Criando serviços
        UsuarioService usuarioService = new UsuarioService(usuarioRepositoryInterface);
        CarteiraService carteiraService = new CarteiraService(carteiraRepositoryInterface);
        TransacaoService transacaoService = new TransacaoService(transacaoRepositoryInterface);

        // Criando com.criptoinvest.controllers
        UsuarioController usuarioController = new UsuarioController(usuarioService, usuarioRepositoryInterface);
        CarteiraController carteiraController = new CarteiraController(carteiraService, carteiraRepositoryInterface, usuarioService);
        TransacaoController transacaoController = new TransacaoController(
                transacaoService,
                carteiraService,
                carteiraRepositoryInterface,
                transacaoRepositoryInterface
        );


        //HashMap
        Map<Carteira, List<Transacao>> mapaCarteiraTransacoes = new HashMap<>();

        while (true) {
            Menu.exibirmenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuarioController.criarUsuario(scanner);
                    break;

                case 2:
                    //Atualiza Usuario fase 5
                    usuarioController.atualizarUsuario(scanner);
                    break;

                case 3:
                    //Deleta usuario
                    usuarioController.excluirUsuario(scanner);
                    break;
                case 4:
                    //lista usuario no banco
                    usuarioController.listarUsuarios();
                    break;

                case 5:
                    // cria carteira
                    carteiraController.criarCarteira(carteira, scanner);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }




}
