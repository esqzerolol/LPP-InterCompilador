import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class BoolCompiler {

    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");  // Concatena as linhas do arquivo
            }
        }catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }
        return content.toString();
    }

    public static void main(String[] args) {
        BoolCompiler compiler = new BoolCompiler();

        String filePath = "teste.txt";  

        // Ler o conteúdo do arquivo
        String code = compiler.readFile(filePath);
        // System.out.println(code);

        // Criar o Lexer e tokenizar o código
        Lexer lexer = new Lexer(code);
        lexer.tokenize();

        // Exibir os tokens gerados
        lexer.printTokens();
    }
}