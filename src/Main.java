import models.Carteira;
import models.Empresa;
import models.Transacao;
import models.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        // Criando os repositórios
        UsuarioRepository usuarioRepository = new UsuarioRepository();


        // Criando os serviços
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);


        // Criando e registrando um usuário
        Usuario usuario = new Usuario(1L, "João", "joao@email.com", "1234", "USER");
        usuarioService.registrarUsuario(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());

        // Testando autenticação
        Usuario autenticado = usuarioService.autenticar("joao@email.com", "1234");
        if (autenticado != null) {
            System.out.println("Login bem-sucedido para: " + autenticado.getNome());
        } else {
            System.out.println("Falha na autenticação!");
        }

        // Criando uma carteira para o usuário
        Carteira carteira = new Carteira(1L, usuario.getId(), 1000.0);

        System.out.println("Carteira criada com saldo: " + carteira.getSaldo());

        // Criando uma transação (compra de criptoativos)
        Transacao transacao = new Transacao(1L, carteira.getId(), "Compra", 500.0, "2024-03-11");

        System.out.println("Transação registrada: " + transacao.getTipo() + " de R$ " + transacao.getValor());

        // Criando uma empresa e cadastrando
        Empresa empresa = new Empresa(1L, "CriptoInvest", "Tecnologia Financeira");

        System.out.println("Empresa cadastrada: " + empresa.getNome());

        // Listando empresas cadastradas
        System.out.println("Empresas disponíveis:");

    }
    }