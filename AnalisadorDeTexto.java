import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalisadorDeTexto {
    public static void main(String[] args) {
        String caminhoArquivo = "texto.txt";

        int totalLinhas = 0;
        int totalPalavras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frequenciaPalavras = new HashMap<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                totalLinhas++;
                totalCaracteres += linha.length();

                String[] palavras = linha.toLowerCase().split("\\s+");
                totalPalavras += palavras.length;

                for (String palavra : palavras) {
                    palavra = palavra.replaceAll("[^a-zà-ú0-9]", "");

                    if (!palavra.isEmpty()) {
                        frequenciaPalavras.put(palavra, frequenciaPalavras.getOrDefault(palavra, 0) + 1);
                    }
                }
            }

            System.out.println("Total de linhas: " + totalLinhas);
            System.out.println("Total de palavras: " + totalPalavras);
            System.out.println("Total de caracteres: " + totalCaracteres);

            String palavraMaisFrequente = "";
            int maiorFrequencia = 0;

            for (Map.Entry<String, Integer> entrada : frequenciaPalavras.entrySet()) {
                if (entrada.getValue() > maiorFrequencia) {
                    maiorFrequencia = entrada.getValue();
                    palavraMaisFrequente = entrada.getKey();
                }
            }

            System.out.println("Palavra mais frequente: \"" + palavraMaisFrequente + "\" (" + maiorFrequencia + " vezes)");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}}
}
