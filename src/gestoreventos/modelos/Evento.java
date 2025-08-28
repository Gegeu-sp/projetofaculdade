package gestoreventos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String endereco;
    private LocalDateTime dataHora;
    private String categoria;
    private String descricao;

    public Evento(String nome, String endereco, LocalDateTime dataHora, String categoria, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataHora = dataHora;
        this.categoria = categoria;
        this.descricao = descricao;
    }


    public String getNome() {
    return nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getEndereco() {
    return endereco;
    }

    public String getCategoria() {
    return categoria;
    }  

    public String getDescricao() {
    return descricao;
    }

    @Override
    public String toString() {
        // Linha 53: Cria um formatador de data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // Linha 55: Retorna uma string formatada com todas as informações
        return "Nome: " + nome + ", Data: " + dataHora.format(formatter) + 
               ", Local: " + endereco + ", Categoria: " + categoria;
    }
}