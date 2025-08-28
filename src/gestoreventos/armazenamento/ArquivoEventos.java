package gestoreventos.armazenamento;

import gestoreventos.modelos.Evento;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ArquivoEventos {
    private static final String NOME_ARQUIVO = "events.data";
    public static void salvarEventos(List<Evento> eventos) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO));
            oos.writeObject(eventos);
            oos.close();
            System.out.println("Eventos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Evento> carregarEventos() {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
            List<Evento> eventos = (List<Evento>) ois.readObject();
            ois.close();
            return eventos;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar eventos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
