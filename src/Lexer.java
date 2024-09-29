import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private String input;  // O código fonte a ser lido
    private List<Token> tokens;  // Lista de tokens gerados

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
    }

    // Método para tokenizar o código
    public void tokenize() {
        // Expressões regulares para identificar diferentes tipos de tokens
        String regex = "\\b(class|method|vars|return|self)\\b|\\b[a-zA-Z_][a-zA-Z0-9_]*\\b|\\b\\d+\\b|\\b(if|else)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Percorrer todas as correspondências (tokens) encontradas
        while (matcher.find()) {
            String tokenValue = matcher.group();
            String tokenType;

            // Identificar o tipo de token
                if (tokenValue.matches("\\b(class|method|begin|self|vars|end|if|return|eq|ne|vars|return|self)\\b")) {
                tokenType = "PALAVRA_CHAVE";
            }   else {
            
                tokenType = "NÃO PALAVRA-CHAVE";
            }

            // Criar um novo token e adicionar à lista
            Token token = new Token(tokenType, tokenValue);
            tokens.add(token);
        }
    }
    // Método para imprimir os tokens gerados (para testar)
    public void printTokens() {
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
