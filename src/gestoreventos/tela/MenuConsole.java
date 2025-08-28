// Linha 1: Pacote - organiza este arquivo na pasta tela
package gestoreventos.tela;

// Linha 3: Importações necessárias
import gestoreventos.logica.GerenciadorEventos;
import gestoreventos.logica.GerenciadorUsuarios;
import gestoreventos.modelos.Evento;
import gestoreventos.modelos.Usuario;
import java.util.Scanner;

// Linha 10: Classe responsável por mostrar o menu e interagir com o usuário
public class MenuConsole {
    
    // Linha 13: Scanner para ler entrada do usuário
    private Scanner scanner;
    // Linha 15: Gerenciador de usuários
    private GerenciadorUsuarios gerenciadorUsuarios;
    // Linha 17: Gerenciador de eventos
    private GerenciadorEventos gerenciadorEventos;
    
    // Linha 20: Construtor - inicializa as dependências
    public MenuConsole() {
        this.scanner = new Scanner(System.in);
        this.gerenciadorUsuarios = new GerenciadorUsuarios();
        this.gerenciadorEventos = new GerenciadorEventos();
    }
    
    // Linha 27: Método principal que mostra o menu e processa opções
    public void mostrarMenu() {
        int opcao;
        
        do {
            // Linha 31-37: Mostra o menu principal
            System.out.println("\n=== AGENDA DE EVENTOS ===");
            System.out.println("1 - Cadastrar novo usuario");
            System.out.println("2 - Ver todos os eventos");
            System.out.println("3 - Confirmar presenca em evento");
            System.out.println("4 - Ver meus eventos confirmados");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opcao: ");
            
            // Linha 40: Lê a opção digitada
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            
            // Linha 44-58: Processa a opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    confirmarPresenca();
                    break;
                case 4:
                    verEventosConfirmados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    // Linha 64-76: Método para cadastrar usuário
    private void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        
        // Linha 74: Cria novo usuário e adiciona ao gerenciador
        Usuario usuario = new Usuario(nome, email, cidade);
        gerenciadorUsuarios.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    // Linha 79-90: Método para listar eventos
    private void listarEventos() {
        System.out.println("\n=== LISTA DE EVENTOS ===");
        if (gerenciadorEventos.getQuantidadeEventos() == 0) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            // Linha 85: Obtém eventos ordenados por data
            var eventosOrdenados = gerenciadorEventos.getEventosOrdenados();
            // Linha 87: Mostra cada evento com número
            for (int i = 0; i < eventosOrdenados.size(); i++) {
                System.out.println((i + 1) + " - " + eventosOrdenados.get(i));
            }
        }
    }
    
    // Linha 93-130: Método para confirmar presença em evento
    private void confirmarPresenca() {
        // Linha 95: Verifica se tem usuários cadastrados
        if (gerenciadorUsuarios.getQuantidadeUsuarios() == 0) {
            System.out.println("Nenhum usuário cadastrado. Cadastre-se primeiro.");
            return;
        }
        
        // Linha 100: Verifica se tem eventos disponíveis
        if (gerenciadorEventos.getQuantidadeEventos() == 0) {
            System.out.println("Nenhum evento disponível.");
            return;
        }
        
        // Linha 105-109: Mostra lista de usuários para seleção
        System.out.println("Selecione um usuário:");
        for (int i = 0; i < gerenciadorUsuarios.getQuantidadeUsuarios(); i++) {
            System.out.println((i + 1) + " - " + gerenciadorUsuarios.getUsuario(i).getNome());
        }
        System.out.print("Digite o número do usuário: ");
        int usuarioIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        // Linha 115-118: Valida índice do usuário
        if (usuarioIndex < 0 || usuarioIndex >= gerenciadorUsuarios.getQuantidadeUsuarios()) {
            System.out.println("Usuário inválido.");
            return;
        }
        
        // Linha 122: Obtém o usuário selecionado
        Usuario usuario = gerenciadorUsuarios.getUsuario(usuarioIndex);
        
        // Linha 125-126: Mostra eventos e pede seleção
        System.out.println("Selecione um evento:");
        listarEventos();
        System.out.print("Digite o número do evento: ");
        int eventoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        // Linha 132-135: Valida índice do evento
        if (eventoIndex < 0 || eventoIndex >= gerenciadorEventos.getQuantidadeEventos()) {
            System.out.println("Evento inválido.");
            return;
        }
        
        // Linha 138-139: Adiciona evento aos confirmados do usuário
        Evento evento = gerenciadorEventos.getEvento(eventoIndex);
        usuario.adicionarEventoConfirmado(evento);
        System.out.println("Presença confirmada com sucesso!");
    }
    
    // Linha 142-162: Método para ver eventos confirmados
    private void verEventosConfirmados() {
        // Linha 144: Verifica se tem usuários
        if (gerenciadorUsuarios.getQuantidadeUsuarios() == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        
        // Linha 149-153: Mostra lista de usuários para seleção
        System.out.println("Selecione um usuário:");
        for (int i = 0; i < gerenciadorUsuarios.getQuantidadeUsuarios(); i++) {
            System.out.println((i + 1) + " - " + gerenciadorUsuarios.getUsuario(i).getNome());
        }
        System.out.print("Digite o número do usuário: ");
        int usuarioIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        // Linha 159-162: Valida e mostra eventos confirmados
        if (usuarioIndex >= 0 && usuarioIndex < gerenciadorUsuarios.getQuantidadeUsuarios()) {
            Usuario usuario = gerenciadorUsuarios.getUsuario(usuarioIndex);
            usuario.mostrarEventosConfirmados();
        } else {
            System.out.println("Usuário inválido.");
        }
    }
    
    // Linha 165-167: Getters para acessar os gerenciadores (para uso externo)
    public GerenciadorUsuarios getGerenciadorUsuarios() {
        return gerenciadorUsuarios;
    }
    
    public GerenciadorEventos getGerenciadorEventos() {
        return gerenciadorEventos;
    }
}