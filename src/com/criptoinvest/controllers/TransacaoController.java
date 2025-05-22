package com.criptoinvest.controllers;

import com.criptoinvest.models.Carteira;
import com.criptoinvest.models.Transacao;
import com.criptoinvest.repository.CarteiraRepository;
import com.criptoinvest.repository.TransacaoRepository;
import com.criptoinvest.service.CarteiraService;
import com.criptoinvest.service.TransacaoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class TransacaoController {
    private Carteira carteira;
    private final CarteiraService carteiraService;
    private final TransacaoService transacaoService;
    private final CarteiraRepository carteiraRepository;
    private final TransacaoRepository transacaoRepository;


    // Construtor para injetar a dependência do TransacaoService
    public TransacaoController(TransacaoService transacaoService,
                               CarteiraService carteiraService,
                               CarteiraRepository carteiraRepository,
                               TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.carteiraService = carteiraService;
        this.carteiraRepository = carteiraRepository;
        this.transacaoRepository = transacaoRepository;
    }

    // Método para criar uma transação
    public Transacao criarTransacao(Transacao transacao) {
        return transacaoService.criarTransacao(transacao);  // Chama o método no serviço
    }

    public void armazenaHistoricoTransacao(Long idCarteiraGerado, Map<Carteira, List<Transacao>> mapaCarteiraTransacoes) {
        try{
            Optional<Carteira> carteiraHist = carteiraRepository.buscarPorId(idCarteiraGerado);

            if (carteiraHist.isPresent()) {
                Carteira carteira = carteiraHist.get();
                List<Transacao> transacoes = transacaoRepository.findByCarteira(carteira);

                if (transacoes.isEmpty()) {
                    throw new IllegalArgumentException("O histórico de transações está vazio.");
                }

                mapaCarteiraTransacoes.put(carteira, transacoes);
                System.out.println("Historico de transações armazenado no HashMap  com sucesso!");


            } else {
                System.out.println("Carteira não encontrada.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro Inesperado: " + e.getMessage());
        }
    }


    public void criarTransacao(Long idCarteiraGerado, Scanner scanner) {
        try {
            Optional<Carteira> carteiraOpt = carteiraRepository.buscarPorId(idCarteiraGerado);

            if (carteiraOpt.isEmpty()) {
                System.out.println("Carteira não encontrada.");
                return;
            }

            carteira = carteiraOpt.get();
            System.out.println("Saldo atual: " + carteira.getSaldo());

            System.out.print("Tipo de Transação (DEPOSITO/SAQUE): ");
            String tipo = scanner.nextLine().toUpperCase();

            if (!tipo.equals("DEPOSITO") && !tipo.equals("SAQUE")) {
                throw new IllegalArgumentException("Tipo de transação invalido");
            }

            System.out.print("Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            if (valor <= 0) {
                throw new IllegalArgumentException("Valor invalido");
            }

            Transacao transacao = new Transacao((long) (Math.random() * 1000),
                    carteiraOpt.get(), tipo, valor, LocalDateTime.now());

            if (tipo.equals("DEPOSITO")) {
                carteiraService.adicionarFundo(carteira, valor);

            } else if (tipo.equals("SAQUE")) {
                carteiraService.retirarFundo(carteira, valor);
            }

            transacaoService.criarTransacao(transacao);
            System.out.println("Transação realizada com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Erro: O valor deve ser um número válido.");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Erro Inesperado: " + e.getMessage());
        }

    }

}




