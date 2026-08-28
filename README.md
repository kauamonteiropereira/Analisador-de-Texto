# 📝 Analisador de Texto
 
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/licen%C3%A7a-MIT-blue?style=for-the-badge)
![Nível](https://img.shields.io/badge/n%C3%ADvel-intermedi%C3%A1rio-orange?style=for-the-badge)

 
Programa em Java que lê um arquivo de texto (`texto.txt`) e exibe estatísticas sobre ele, como total de linhas, palavras e caracteres.
 
---
 
## 📋 Descrição
 
O programa abre o arquivo `texto.txt` usando `BufferedReader`, lê linha por linha, e vai contando o número de linhas, palavras e caracteres do arquivo inteiro.
 
## 💻 Código
 
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class AnalisadorDeTexto {
    public static void main(String[] args) {
        String caminhoArquivo = "texto.txt";
 
        int totalLinhas = 0;
        int totalPalavras = 0;
        int totalCaracteres = 0;
 
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
 
            while ((linha = leitor.readLine()) != null) {
                totalLinhas++;
                totalCaracteres += linha.length();
 
                String[] palavras = linha.split("\\s+");
                totalPalavras += palavras.length;
            }
 
            System.out.println("Total de linhas: " + totalLinhas);
            System.out.println("Total de palavras: " + totalPalavras);
            System.out.println("Total de caracteres: " + totalCaracteres);
 
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
 
## 🧠 Conceitos praticados
 
- Leitura de arquivos (`BufferedReader`, `FileReader`)
- Tratamento de exceções (`try/catch`, `IOException`)
- `try-with-resources`
- Manipulação de Strings (`split`, `length`)
## 🚀 Próximos passos
 
- Identificar a palavra mais frequente do texto, usando `HashMap`.
- Ignorar pontuação na contagem de palavras.
- Permitir que o usuário escolha qual arquivo ler, via `Scanner`.
---
 
<p align="center">Feito com ☕ e Java</p>
 
