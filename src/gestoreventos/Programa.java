// Linha 1: Pacote - organiza este arquivo na raiz do projeto
package gestoreventos;

// Linha 3: Importações necessárias
import gestoreventos.armazenamento.ArquivoEventos;
import gestoreventos.logica.GerenciadorEventos;
import gestoreventos.modelos.Evento;
import gestoreventos.tela.MenuConsole;
import java.time.LocalDateTime;
import java.util.List;

// Linha 10: Classe principal - ponto de entrada do programa
public class Programa {
    
    // Linha 13: Método principal - onde tudo começa
    public static void main(String[] args) {
        // Linha 15: Cria o menu console (interface com usuário)
        MenuConsole menu = new MenuConsole();
        
        // Linha 17: Carrega eventos salvos do arquivo
        carregarEventosDoArquivo(menu.getGerenciadorEventos());
        
        // Linha 19: Adiciona eventos iniciais (exemplos)
        adicionarEventosIniciais(menu.getGerenciadorEventos());
        
        // Linha 21: Mostra o menu principal para o usuário
        menu.mostrarMenu();
        
        // Linha 23: Quando usuário sai, salva eventos no arquivo
        salvarEventosNoArquivo(menu.getGerenciadorEventos());
    }
    
    // Linha 27-38: Método para carregar eventos do arquivo
    private static void carregarEventosDoArquivo(GerenciadorEventos gerenciador) {
        System.out.println("Carregando eventos do arquivo...");
        // Linha 30: Chama método da classe ArquivoEventos para carregar
        List<Evento> eventosCarregados = ArquivoEventos.carregarEventos();
        
        // Linha 33: Adiciona cada evento carregado ao gerenciador
        for (Evento evento : eventosCarregados) {
            gerenciador.adicionarEvento(evento);
        }
        
        // Linha 37: Mostra quantos eventos foram carregados
        System.out.println("Eventos carregados: " + eventosCarregados.size());
    }
    
    // Linha 41-54: Método para adicionar eventos iniciais (exemplos)
    private static void adicionarEventosIniciais(GerenciadorEventos gerenciador) {
        // Linha 43-45: Verifica se já tem eventos (para não duplicar)
        if (gerenciador.getQuantidadeEventos() == 0) {
            System.out.println("Adicionando eventos iniciais...");
            
            // Linha 48-52: Adiciona eventos de exemplo
            gerenciador.adicionarEvento(new Evento(
                "Ensaio Navoz", 
                "My home", 
                LocalDateTime.of(2025, 10, 06, 14, 0), 
                "Ensaio", 
                "Ensaio vocal"
            ));
            
            gerenciador.adicionarEvento(new Evento(
                "Aniversario Luciana", 
                "Churrasqueira", 
                LocalDateTime.of(2025, 12, 05, 20, 0), 
                "Festa", 
                "Aniversario Luciana"
            ));
        }
    }
    
    // Linha 57-62: Método para salvar eventos no arquivo ao sair
    private static void salvarEventosNoArquivo(GerenciadorEventos gerenciador) {
        System.out.println("Salvando eventos no arquivo...");
        // Linha 60: Chama método da classe ArquivoEventos para salvar
        ArquivoEventos.salvarEventos(gerenciador.getEventos());
        System.out.println("Programa encerrado.");
    }
}