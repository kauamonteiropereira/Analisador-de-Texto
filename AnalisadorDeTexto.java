import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalisadorDeTexto {
    public static void main(String[] args) {
        String caminhoArquivo = "texto.txt";

        try (BufferedReader leitor = new BufferedReader( new FileReader(caminhoArquivo ))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);

            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());

        }
    }
}