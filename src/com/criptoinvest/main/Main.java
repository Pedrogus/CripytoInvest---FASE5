package com.criptoinvest.main;

import com.criptoinvest.models.Transacao;
import com.criptoinvest.models.Usuario;
import com.criptoinvest.controllers.*;
import com.criptoinvest.models.*;
import com.criptoinvest.repository.*;
import com.criptoinvest.service.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);

        // Criando repositórios
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        CarteiraRepository carteiraRepository = new CarteiraRepositoryImpl();
        TransacaoRepository transacaoRepository = new TransacaoRepositoryImpl();

        // Criando serviços
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        CarteiraService carteiraService = new CarteiraService(carteiraRepository);
        TransacaoService transacaoService = new TransacaoService(transacaoRepository);

        // Criando com.criptoinvest.controllers
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        CarteiraController carteiraController = new CarteiraController(carteiraService);
        TransacaoController transacaoController = new TransacaoController(transacaoService);

        System.out.print("ID da Carteira (ou 0 para criar uma nova): ");
        Long carteiraId = scanner.nextLong();
        if (carteiraId == 0) {
            carteiraId = (long) (Math.random() * 1000);
            System.out.println("Criando nova carteira com ID: " + carteiraId);
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Criar Carteira");
            System.out.println("3. Adicionar Fundos à Carteira");
            System.out.println("4. Criar Transação");
            System.out.println("5. Exibir Histórico de Transações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    Usuario usuario = new Usuario((long) (Math.random() * 1000), nome, email, senha, "USER");
                    usuarioService.registrarUsuario(usuario);
                    System.out.println("Usuário registrado com sucesso!");
                    System.out.println("Id do Usuario: " + usuario.getId());
                    break;
                case 2:
                    System.out.print("ID do Usuário: ");
                    Long userId = scanner.nextLong();
                    Usuario user = usuarioService.buscarPorId(userId);
                  if (user != null) {
                	  System.out.print("Saldo inicial: ");
                      double saldo = scanner.nextDouble();
                      
                      Long carteiraIdGerado = (long) (Math.random() * 1000);
                      Carteira novaCarteira = new Carteira(carteiraIdGerado, user, saldo);
                      carteiraRepository.salvar(novaCarteira);
                      
                      System.out.println("Carteira criada com sucesso! ID: " + novaCarteira.getId());
                  	} else {
                  		System.out.println("Usuário não encontrado.");
                  }
                    break;
                case 3:
                	System.out.println("Buscando carteira com ID: " + carteiraId);
                    Optional<Carteira> carteiraI = carteiraRepository.buscarPorId(carteiraId);
                    
                    if (carteiraI.isPresent()) {
                        System.out.print("Valor a adicionar: ");
                        double valor = scanner.nextDouble();
                        carteiraService.adicionarFundo(carteiraI.get(), valor);
                        System.out.println("Fundos adicionados com sucesso!");
                    } else {
                        System.out.println("Erro: Carteira não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("ID da Carteira: ");
                    Long idCarteira = scanner.nextLong();
                    Optional<Carteira> carteiraOpt = carteiraRepository.buscarPorId(idCarteira);
                    if (carteiraOpt.isPresent()) {
                        System.out.print("Tipo de Transação (DEPÓSITO/SAQUE): ");
                        scanner.nextLine();
                        String tipo = scanner.nextLine();
                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();
                        Transacao transacao = new Transacao((long) (Math.random() * 1000), carteiraOpt.get(), tipo, valor, LocalDateTime.now());
                        transacaoController.criarTransacao(transacao);
                        System.out.println("Transação realizada com sucesso!");
                    } else {
                        System.out.println("Carteira não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("ID da Carteira: ");
                    Long idCart = scanner.nextLong();
                    Optional<Carteira> carteiraHist = carteiraRepository.buscarPorId(idCart);
                    if (carteiraHist.isPresent()) {
                        List<Transacao> transacoes = transacaoRepository.findByCarteira(carteiraHist.get());
                        System.out.println("Histórico de transações:");
                        for (Transacao t : transacoes) {
                            System.out.println("- " + t.getTipo() + " de R$ " + t.getValor() + " em " + t.getData());
                        }
                    } else {
                        System.out.println("Carteira não encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
         */

        Cliente cliente = new Cliente(1L, "Maria", "marry@email.com","senha","Cliente");
        Transacao transacao = new Transacao();

        cliente.exibirDados();

        // Realizando uma transação de adicionar saldo
        transacao.adicionarSaldo(cliente.getCarteira(), 100.0);

        // Exibindo informações do cliente após a transação de adicionar saldo
        cliente.exibirDados();

        // Realizando uma transação de retirar saldo
        transacao.retirarSaldo(cliente.getCarteira(), 50.0);

        // Exibindo informações do cliente após a transação de retirar saldo
        cliente.exibirDados();
    }


}
