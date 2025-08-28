// Linha 1: Pacote
package gestoreventos.logica;

// Linha 3: Importações
import gestoreventos.modelos.Evento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Linha 10: Classe para gerenciar eventos
public class GerenciadorEventos {
    
    // Linha 13: Lista para armazenar todos os eventos
    private List<Evento> eventos;
    
    // Linha 16: Construtor - inicializa a lista
    public GerenciadorEventos() {
        this.eventos = new ArrayList<>();
    }
    
    // Linha 21-25: Método para adicionar evento
    public void adicionarEvento(Evento evento) {
        // Linha 23: Adiciona o evento à lista
        eventos.add(evento);
    }
    
    // Linha 28-35: Método para obter eventos ordenados por data
    public List<Evento> getEventosOrdenados() {
        // Linha 30: Cria uma cópia da lista para não modificar a original
        List<Evento> eventosOrdenados = new ArrayList<>(eventos);
        // Linha 32: Ordena por data (mais próximos primeiro)
        Collections.sort(eventosOrdenados, Comparator.comparing(Evento::getDataHora));
        return eventosOrdenados;
    }
    
    // Linha 38-40: Método para obter evento por índice
    public Evento getEvento(int indice) {
        // Linha 39: Verifica se o índice é válido
        if (indice >= 0 && indice < eventos.size()) {
            return eventos.get(indice);
        }
        return null; // Retorna null se índice inválido
    }
    
    // Linha 45-47: Método para obter quantidade de eventos
    public int getQuantidadeEventos() {
        return eventos.size();
    }
    
    // Linha 50-52: Método para obter todos os eventos
    public List<Evento> getEventos() {
        return eventos;
    }
}