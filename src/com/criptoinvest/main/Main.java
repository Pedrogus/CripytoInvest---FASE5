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

        Scanner scanner = new Scanner(System.in);

        //Criando Models
        Carteira carteira = new Carteira();
        Usuario usuario = null;

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


        // comeco do menu
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Criar Carteira");
            System.out.println("3. Criar Transação");
            System.out.println("4. Exibir Histórico de Transações");
            System.out.println("5. Exibir dados dos Usuarios");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                try {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    if (nome.isBlank()) {
                        throw new IllegalArgumentException("O nome não pode estar em branco!");
                    }

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if (email.isBlank()) {
                        throw new IllegalArgumentException("O email não pode estar em branco!");
                    }

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    if (senha.isBlank()) {
                        throw new IllegalArgumentException("O senha não pode estar em branco!");
                    }

                    System.out.print("Role (CLIENTE/EMPRESA): ");
                    String role = scanner.nextLine().toUpperCase();


                    if (role.equals("CLIENTE")) {

                        System.out.print("Digite seu cpf: ");
                        String cpf = scanner.nextLine();
                        if (cpf.isBlank()) {
                            throw new IllegalArgumentException("O cpf não pode estar em branco!");
                        }

                        usuario = new Cliente((long) (Math.random() * 1000), nome, email, senha, "Cliente", cpf);
                        System.out.println("Usuario criado com sucesso! ID: " + usuario.getId());

                    } else if (role.equals("EMPRESA")) {

                        System.out.print("Setor da Empresa: ");
                        String setor = scanner.nextLine();
                        if (setor.isBlank()) {
                            throw new IllegalArgumentException("O setor não pode estar em branco!");
                        }

                        System.out.print("cnpj da Empresa: ");
                        String cnpj = scanner.nextLine();
                        if (cnpj.isBlank()) {throw new IllegalArgumentException("O cnpj não pode estar em branco!");}

                        usuario = new Empresa((long) (Math.random() * 1000), nome, email, setor, cnpj);
                        System.out.println("Usuario criada com sucesso! ID: " + usuario.getId());
                    } else {
                        throw new IllegalArgumentException("Role inválido!. Use CLIENTE or EMPRESA.");
                    }
                    usuarioRepository.salvar(usuario);

                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                }
                break;

                case 2:
                    try {
                        System.out.print("ID do Usuário: ");
                        Long userId = scanner.nextLong();
                        scanner.nextLine();
                        Usuario user = usuarioService.buscarPorId(userId);

                        if (user != null) {
                            System.out.print("Saldo inicial: ");
                            String saldoInput = scanner.nextLine();

                            if(saldoInput.isBlank()) {System.out.print("Erro: O saldo não pode estar vazio");}

                            double saldo = Double.parseDouble(saldoInput);
                            if (saldo < 0) {
                                throw new IllegalArgumentException("Saldo Invalido");
                            }

                            carteira.carteiraIdGerado = (long) (Math.random() * 1000);
                            Carteira novaCarteira = new Carteira(carteira.carteiraIdGerado, user, saldo);
                            carteiraRepository.salvar(novaCarteira);

                            System.out.println("Carteira criada com sucesso! ID: " + novaCarteira.getId());
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }

                    } catch(NumberFormatException e) {
                        System.out.println("Erro: O saldo deve ser um número válido.");
                  } catch (InputMismatchException e) {
                        System.out.println("Erro: Entrada inválida. Por favor, insira números corretamente.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado: " + e.getMessage());
                    }
                    break;


                case 3:
                    try {
                        System.out.print("ID da Carteira: ");
                        String idCarteiraInput = scanner.nextLine();


                        Long idCarteiraGerado = Long.parseLong(idCarteiraInput);
                        Optional<Carteira> carteiraOpt = carteiraRepository.buscarPorId(idCarteiraGerado);

                        if (carteiraOpt.isPresent()) {
                            carteira = carteiraOpt.get();
                            System.out.println("Saldo atual: " + carteira.getSaldo());

                            System.out.print("Tipo de Transação (DEPÓSITO/SAQUE): ");
                            String tipo = scanner.nextLine().toUpperCase();

                            if (tipo.isBlank()) {
                                throw new IllegalArgumentException("Tipo da transação deve ser valido");
                            }

                            System.out.print("Valor: ");
                            String valorInput = scanner.nextLine();
                            if (valorInput.isBlank()) {
                                throw new IllegalArgumentException("Valor não pode estar vazio.");
                            }

                            double valor = Double.parseDouble(valorInput);
                            if (valor < 0) {
                                throw new IllegalArgumentException("Valor invalido");
                            }

                            Transacao transacao = new Transacao((long) (Math.random() * 1000), carteiraOpt.get(), tipo, valor, LocalDateTime.now());

                            if (tipo.equals("DEPOSITO")) {
                                carteiraService.adicionarFundo(carteira, valor);
                                transacaoController.criarTransacao(transacao);

                            } else if (tipo.equals("SAQUE")) {
                                carteiraService.retirarFundo(carteira, valor);
                                transacaoController.criarTransacao(transacao);

                            }
                                System.out.println("Transação realizada com sucesso!");
                        } else {
                            System.out.println("Carteira não encontrada.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado: " + e.getMessage());
                    }
                    break;


                case 4:
                    try {
                        System.out.print("ID da Carteira: ");
                        String idCarteiraInput = scanner.nextLine();

                        Long idCarteiraGerado = Long.parseLong(idCarteiraInput);
                        Optional<Carteira> carteiraHist = carteiraRepository.buscarPorId(idCarteiraGerado);

                        if (carteiraHist.isPresent()) {
                            List<Transacao> transacoes = transacaoRepository.findByCarteira(carteiraHist.get());

                            if (transacoes.isEmpty()) {
                                throw new IllegalStateException("O histórico de transações está vazio.");
                            }

                            System.out.println("Histórico de transações:");
                            for (Transacao t : transacoes) {
                                System.out.println("- " + t.getTipo() + " de R$ " + t.getValor() + " em " + t.getData() + " Saldo final: " + carteira.getSaldo());
                            }
                        } else {
                            System.out.println("Carteira não encontrada.");
                        }
                    }  catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro Inesperado: " + e.getMessage());
                    }
                    break;


                case 5:
                    System.out.println("Lista de users: " + usuarioController.listarUsuarios());
                        break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        //final do menu
    }




}
