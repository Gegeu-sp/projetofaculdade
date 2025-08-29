package gestoreventos;

import gestoreventos.armazenamento.ArquivoEventos;
import gestoreventos.logica.GerenciadorEventos;
import gestoreventos.modelos.Evento;
import gestoreventos.tela.MenuConsole;
import java.time.LocalDateTime;
import java.util.List;


public class Programa {
    
  
    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        carregarEventosDoArquivo(menu.getGerenciadorEventos());
        adicionarEventosIniciais(menu.getGerenciadorEventos());
        menu.mostrarMenu();
        salvarEventosNoArquivo(menu.getGerenciadorEventos());
    }
    
    private static void carregarEventosDoArquivo(GerenciadorEventos gerenciador) {
        System.out.println("Carregando eventos do arquivo...");
        List<Evento> eventosCarregados = ArquivoEventos.carregarEventos();
        
        for (Evento evento : eventosCarregados) {
            gerenciador.adicionarEvento(evento);
        }
        
        System.out.println("Eventos carregados: " + eventosCarregados.size());
    }
    private static void adicionarEventosIniciais(GerenciadorEventos gerenciador) {
        if (gerenciador.getQuantidadeEventos() == 0) {
            System.out.println("Adicionando eventos iniciais...");
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
    
    private static void salvarEventosNoArquivo(GerenciadorEventos gerenciador) {
        System.out.println("Salvando eventos no arquivo...");
        ArquivoEventos.salvarEventos(gerenciador.getEventos());
        System.out.println("Programa encerrado.");
    }
}