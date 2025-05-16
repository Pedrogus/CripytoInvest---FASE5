package com.criptoinvest.main;

import com.criptoinvest.controllers.CarteiraController;
import com.criptoinvest.controllers.TransacaoController;
import com.criptoinvest.controllers.UsuarioController;
import com.criptoinvest.models.*;
import com.criptoinvest.repository.*;
import com.criptoinvest.service.CarteiraService;
import com.criptoinvest.service.TransacaoService;
import com.criptoinvest.service.UsuarioService;

import java.time.LocalDateTime;
import java.util.*;

public class Menu {

    public static void exibirmenu() {

            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Criar Carteira");
            System.out.println("3. Criar Transação");
            System.out.println("4. Exibir Histórico de Transações");
            System.out.println("5. Exibir dados dos Usuarios");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");


    }
}
