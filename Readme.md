
# 💰 CriptoInvest

**CriptoInvest** é uma plataforma rápida e segura para investimentos em criptoativos.  
Este repositório contém todas as classes Java utilizadas no projeto, organizadas em pacotes de acordo com sua responsabilidade.

📽️ **Video Pitch:** [Assista aqui](https://youtu.be/CW81d4Z16YI)

---

## 👨‍💻 Equipe - TechSquad

- **Nicolas de Lima Silvestrini**  
  📧 nickv3nom@outlook.com

- **Pedro Gustavo Juchimiuk de Oliveira**  
  📧 pedrojuchimiuk@gmail.com

- **Pedro Henrique Ramondini Palmeira**  
  📧 peramondini709@gmail.com

---

> Projeto desenvolvido como parte da disciplina de Engenharia de Software – Fase 4.

## 📦 Estrutura do Projeto

### ✅ Lógica do Sistema

O sistema é baseado em um **menu interativo**, onde o usuário escolhe uma das opções disponíveis, cada uma acionando um conjunto de operações específicas por meio de um **switch-case**. Esse fluxo orienta a execução de todas as funcionalidades principais do sistema.

### 🧩 Estrutura geral do menu

- **Criar Usuário**  
  O sistema permite o cadastro de novos usuários, que podem ser **Cliente** ou **Empresa**.  
  Demonstra a aplicação de **herança** e **polimorfismo** no tratamento genérico de objetos do tipo `Usuario`.


- **Criar Carteira**  
  Associa uma **Carteira** a um **Usuário**.  
  Reflete boas práticas de **normalização**, separando claramente as entidades `Usuario` e `Carteira`.


- **Criar Transação**  
  Permite realizar operações financeiras (como **depósito** ou **saque**) vinculadas a uma **Carteira** específica. A transação é armazenada em uma **lista** associada à carteira.



- **Armazenar e Exibir Histórico de Transações**  
  As transações são associadas às carteiras através de um **HashMap**, onde cada chave representa uma **Carteira** e o valor uma **Lista de Transações**.  
  O professor pode visualizar nesta funcionalidade como o **HashMap** é utilizado para criar uma relação eficiente entre dois tipos de dados.  
  Além disso, a funcionalidade `armazenaHistoricoTransacao` organiza o histórico, reforçando a importância de **coleções dinâmicas** em Java.



- **Listar Usuários**  
  Exibe todos os usuários cadastrados, sejam **Clientes** ou **Empresas**, utilizando um **ArrayList**.

  Aqui o professor consegue identificar o uso de **polimorfismo**, pois a listagem é feita de maneira uniforme para os diferentes tipos de usuário.  
  Mostra também como **coleções genéricas** são utilizadas para manipular objetos que compartilham uma **superclasse**.

  
- **Sair**  
  Encerra o programa de forma segura, finalizando a execução e liberando recursos como o `Scanner`.

---

## 🚀 Execução

No método `main`, você encontrará um teste funcional que realiza:
- Criação dos repositórios
- Autenticação de usuário
- Criação de empresas
- Criação de carteiras para usuários

---


