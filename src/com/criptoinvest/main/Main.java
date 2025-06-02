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
                    carteiraController.criarCarteira(carteira, scanner);
                    break;

                case 3:
                    try {
                        System.out.print("ID da Carteira: ");
                        Long idCarteiraGerado = Long.parseLong(scanner.nextLine());
                        transacaoController.criarTransacao(idCarteiraGerado, scanner);
                    } catch(NumberFormatException e) {
                        System.out.println("Numero da carteira deve ser vailido");
                    }
                    break;


                    // HashMap de Carteira e Transação
                case 4:
                    try {
                        System.out.print("ID da Carteira: ");
                        String idCarteiraInput = scanner.nextLine();
                        Long idCarteiraGerado = Long.parseLong(idCarteiraInput);

                        transacaoController.armazenaHistoricoTransacao(idCarteiraGerado, mapaCarteiraTransacoes);

                        for(Map.Entry<Carteira, List<Transacao>> entry : mapaCarteiraTransacoes.entrySet()) {
                            carteira = entry.getKey();
                            List<Transacao> transacoes = entry.getValue();

                            System.out.println("Carteira ID: " + carteira.getId());
                            System.out.println("Histórico de transações:");

                            for (Transacao t : transacoes) {
                                System.out.println("- " + t.getTipo() + " de R$ " + t.getValor() + " em " + t.getData());
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: ID da carteira deve ser um numero valido");
                    }
                    break;


                case 5:
                    // arrayList de usuario (CLIENTE e EMPRESA)
                    usuarioController.listarUsuarios();
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
