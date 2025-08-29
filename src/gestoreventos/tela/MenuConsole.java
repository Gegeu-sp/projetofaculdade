package gestoreventos.tela;

import gestoreventos.logica.GerenciadorEventos;
import gestoreventos.logica.GerenciadorUsuarios;
import gestoreventos.modelos.Evento;
import gestoreventos.modelos.Usuario;
import java.util.Scanner;

public class MenuConsole {
    
    private Scanner scanner;
    private GerenciadorUsuarios gerenciadorUsuarios;
    private GerenciadorEventos gerenciadorEventos;
    
    public MenuConsole() {
        this.scanner = new Scanner(System.in);
        this.gerenciadorUsuarios = new GerenciadorUsuarios();
        this.gerenciadorEventos = new GerenciadorEventos();
    }
    
    public void mostrarMenu() {
        int opcao;
        
        do {
            System.out.println("\n=== AGENDA DE EVENTOS ===");
            System.out.println("1 - Cadastrar novo usuario");
            System.out.println("2 - Ver todos os eventos");
            System.out.println("3 - Confirmar presenca em evento");
            System.out.println("4 - Ver meus eventos confirmados");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            
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
    
    private void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        
        Usuario usuario = new Usuario(nome, email, cidade);
        gerenciadorUsuarios.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    private void listarEventos() {
        System.out.println("\n=== LISTA DE EVENTOS ===");
        if (gerenciadorEventos.getQuantidadeEventos() == 0) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            var eventosOrdenados = gerenciadorEventos.getEventosOrdenados();
            for (int i = 0; i < eventosOrdenados.size(); i++) {
                System.out.println((i + 1) + " - " + eventosOrdenados.get(i));
            }
        }
    }
    
    private void confirmarPresenca() {
        if (gerenciadorUsuarios.getQuantidadeUsuarios() == 0) {
            System.out.println("Nenhum usuário cadastrado. Cadastre-se primeiro.");
            return;
        }
        
        if (gerenciadorEventos.getQuantidadeEventos() == 0) {
            System.out.println("Nenhum evento disponível.");
            return;
        }
        
        System.out.println("Selecione um usuário:");
        for (int i = 0; i < gerenciadorUsuarios.getQuantidadeUsuarios(); i++) {
            System.out.println((i + 1) + " - " + gerenciadorUsuarios.getUsuario(i).getNome());
        }
        System.out.print("Digite o número do usuário: ");
        int usuarioIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (usuarioIndex < 0 || usuarioIndex >= gerenciadorUsuarios.getQuantidadeUsuarios()) {
            System.out.println("Usuário inválido.");
            return;
        }
        
        Usuario usuario = gerenciadorUsuarios.getUsuario(usuarioIndex);
        
        System.out.println("Selecione um evento:");
        listarEventos();
        System.out.print("Digite o número do evento: ");
        int eventoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (eventoIndex < 0 || eventoIndex >= gerenciadorEventos.getQuantidadeEventos()) {
            System.out.println("Evento inválido.");
            return;
        }
        
        Evento evento = gerenciadorEventos.getEvento(eventoIndex);
        usuario.adicionarEventoConfirmado(evento);
        System.out.println("Presença confirmada com sucesso!");
    }
    
    private void verEventosConfirmados() {
        if (gerenciadorUsuarios.getQuantidadeUsuarios() == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        
        System.out.println("Selecione um usuário:");
        for (int i = 0; i < gerenciadorUsuarios.getQuantidadeUsuarios(); i++) {
            System.out.println((i + 1) + " - " + gerenciadorUsuarios.getUsuario(i).getNome());
        }
        System.out.print("Digite o número do usuário: ");
        int usuarioIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (usuarioIndex >= 0 && usuarioIndex < gerenciadorUsuarios.getQuantidadeUsuarios()) {
            Usuario usuario = gerenciadorUsuarios.getUsuario(usuarioIndex);
            usuario.mostrarEventosConfirmados();
        } else {
            System.out.println("Usuário inválido.");
        }
    }

    public GerenciadorUsuarios getGerenciadorUsuarios() {
        return gerenciadorUsuarios;
    }
    
    public GerenciadorEventos getGerenciadorEventos() {
        return gerenciadorEventos;
    }
}