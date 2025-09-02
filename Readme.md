
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

- **Ezequiael**  
  📧 

- **Leonardo**  
  📧 leonardostati9@outlook.com 
---

> Projeto desenvolvido como parte da disciplina de Engenharia de Software – Fase 5.

## 📦 Estrutura do Projeto  

### 🔹 Funcionalidades principais  

O sistema é baseado em um **menu interativo (switch-case)**, que permite ao usuário escolher operações de **CRUD** sobre a entidade `Usuario`.  

- **Criar Usuário**  
  - Cadastro de novos usuários como **Cliente** ou **Empresa**.  
  - Os dados são persistidos diretamente na **tabela SQL `usuario`** via `INSERT`.  
  - Demonstra **herança** (`Cliente` e `Empresa` estendem `Usuario`).  

- **Listar Usuários**  
  - Consulta (`SELECT`) no banco e exibição dos dados em linha (**ID, Nome, Email, CPF/CNPJ**).  
  - Demonstra uso de **coleções genéricas (`ArrayList<Usuario>`)** para manipulação dos resultados.  

- **Atualizar Usuário**  
  - Alteração de dados existentes via `UPDATE`.  

- **Excluir Usuário**  
  - Remoção de registros via `DELETE`.  

- **Sair**  
  - Finaliza a aplicação de forma segura e libera recursos como `Scanner` e `Connection`.  

---

## 🗄️ Integração com Banco de Dados  

- Conexão implementada via **JDBC (`DriverManager`)** em uma classe utilitária `DatabaseConnection`.  
- Scripts **DDL** e **DML** foram produzidos de acordo com a modelagem relacional.  

### 🔹 Script DDL  
- Criação da tabela `usuario`, com atributos específicos para cada tipo (`cpf` para Cliente, `setor`/`cnpj` para Empresa).  
- Definição de **PKs** e **restrições de integridade**.  

### 🔹 Script DML  
- Exemplos de `INSERT`, `UPDATE`, `DELETE` e `SELECT` para popular e manipular os dados.  

---

## 🚀 Execução e Testes  

Na classe `Main`, são instanciados os repositórios e testadas as operações:  

- Para conectar no banco de dados altere a variavel USER e PASS no arquivo DatabaseConnection.java na pasta persistence
tambem rode o Create_databse_cripto_db.sql para criar o db e as tabelas.

- **Criação de usuários** (inserção no banco).  
- **Listagem de usuários** (consulta e impressão formatada).  
- **Atualização e exclusão de usuários**.  
- **Autenticação de login** simulada.  
- **Criação de carteira** (implementada sem conexão ao banco, apenas com collections).  

---

## 📚 Requisitos da Fase 5 (atendidos neste projeto)  

- ✅ Script **DDL** com `CREATE TABLE` e restrições (PKs, FKs).  
- ✅ Script **DML** com `INSERT`, `UPDATE`, `DELETE` e `SELECT`.  
- ✅ Classes Java organizadas em pacotes (`models`, `repository`, `service`, `controllers`, `config`).  
- ✅ Classe de conexão com banco de dados **Oracle via JDBC**.  
- ✅ Integração de **uma classe (`Usuario`)** com o banco, permitindo **CRUD completo**.  
- ✅ Testes realizados na `Main` com menu interativo.  
