public class Token {
    private String type;  // Tipo do token (ex: palavra-chave, identificador, número)
    private String value; // Valor do token (ex: "class", "Pessoa")

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}