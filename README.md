# 📝 Analisador de Texto
 
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/licen%C3%A7a-MIT-blue?style=for-the-badge)
![Nível](https://img.shields.io/badge/n%C3%ADvel-intermedi%C3%A1rio-orange?style=for-the-badge)
 
Programa em Java que lê um arquivo de texto (`texto.txt`) e exibe estatísticas sobre ele: total de linhas, palavras, caracteres e a palavra mais frequente.
 
---
 
## 📋 Descrição
 
O programa abre o arquivo `texto.txt` usando `BufferedReader`, lê linha por linha, e vai contando o número de linhas, palavras e caracteres do arquivo inteiro. Além disso, usa um `HashMap` para contar quantas vezes cada palavra aparece e identificar a mais frequente.
 
## 💻 Código
 
```java
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
}
```
 
## ▶️ Como executar
 
```bash
javac AnalisadorDeTexto.java
java AnalisadorDeTexto
```
 
Certifique-se de que existe um arquivo `texto.txt` na mesma pasta, com qualquer conteúdo de texto.
 
## 📤 Exemplo de saída
 
Com o texto:
```
Três tigres tristes para três pratos de trigo, três pratos de trigo para três tigres tristes.
```
 
O programa mostra:
```
Total de linhas: 1
Total de palavras: 16
Total de caracteres: 93
Palavra mais frequente: "três" (4 vezes)
```
 
## 🧠 Conceitos praticados
 
- Leitura de arquivos (`BufferedReader`, `FileReader`)
- Tratamento de exceções (`try/catch`, `IOException`)
- `try-with-resources`
- Manipulação de Strings (`split`, `length`, `replaceAll`, `toLowerCase`)
- `HashMap` para contagem de frequência
- Expressões regulares simples
## 🚀 Possíveis melhorias
 
- Permitir que o usuário escolha qual arquivo ler, via `Scanner`.
- Mostrar as 3 ou 5 palavras mais frequentes, não só a primeira.
- Ignorar palavras muito comuns (como "de", "a", "o") na contagem.
---
 
<p align="center">Feito com ☕ e Java</p>
 

