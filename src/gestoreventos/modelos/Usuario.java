// organiza os arquivos em pastas virtuais
package gestoreventos.modelos;

// Importações necessárias
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// representa um usuário do sistema
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos privados
    private String nome;
    private String email;
    private String cidade;
    private List<Evento> eventosConfirmados; 
    
    // criar objetos
    public Usuario(String nome, String email, String cidade) {
        this.nome = nome;           // this.nome = atributo da classe
        this.email = email;         // nome = parâmetro do método
        this.cidade = cidade;

        this.eventosConfirmados = new ArrayList<>();
    }
 
    public String getNome() {
        return nome;
    }

    // Método getter para obter o email
    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }
 
    public void adicionarEventoConfirmado(Evento evento) {
        if (!eventosConfirmados.contains(evento)) {
            eventosConfirmados.add(evento);
        }
    }

    // Método para mostrar eventos confirmados
    public void mostrarEventosConfirmados() {
        System.out.println("\n=== EVENTOS CONFIRMADOS POR " + nome + " ===");
        if (eventosConfirmados.isEmpty()) {
            System.out.println("Nenhum evento confirmado.");
        } else {
            for (Evento evento : eventosConfirmados) {
                System.out.println(evento);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Cidade: " + cidade;
    }
}