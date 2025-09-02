package com.criptoinvest.controllers;

import com.criptoinvest.models.Carteira;
import com.criptoinvest.models.Usuario;
import com.criptoinvest.repository.CarteiraRepositoryInterface;
import com.criptoinvest.service.CarteiraService;
import com.criptoinvest.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarteiraController {
    private final CarteiraRepositoryInterface carteiraRepositoryInterface;
    private  final CarteiraService carteiraService;
    private final UsuarioService usuarioService;

    // Construtor para injetar a dependência do CarteiraService
    public CarteiraController(CarteiraService carteiraService,
                              CarteiraRepositoryInterface carteiraRepositoryInterface,
                              UsuarioService usuarioService) {
        this.carteiraService = carteiraService;
        this.carteiraRepositoryInterface = carteiraRepositoryInterface;
        this.usuarioService = usuarioService;
    }


    public Carteira criarCarteira(Carteira carteira, Scanner scanner) {
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

 //               carteira.carteiraIdGerado = (long) (Math.random() * 1000);
                Carteira novaCarteira = new Carteira(null, user, saldo);
                carteiraRepositoryInterface.salvar(novaCarteira);

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

        return null;

    }

    public void buscarSaldoPorUsuario(Scanner scanner) {
        try {
            System.out.print("Digite o ID do Usuário: ");
            Long userId = scanner.nextLong();
            scanner.nextLine();

            // Buscar o usuário (opcional, para validação)
            Usuario user = usuarioService.buscarPorId(userId);
            if (user == null) {
                System.out.println("Usuário não encontrado.");
                return;
            }

            // Buscar o saldo via repository
            double saldo = carteiraService.buscarSaldoPorUsuario(userId); // ou usar direto repository
            System.out.println("Saldo da carteira do usuário " + userId + ": " + saldo);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira números corretamente.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }


}
