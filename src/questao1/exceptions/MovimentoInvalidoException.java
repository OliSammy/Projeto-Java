package questao1.exceptions;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException() {
        super("Movimento inválido");
    }

    public MovimentoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public MovimentoInvalidoException(String cor, String i) {
        super("O robô " + cor + " fez o movimento " + i + ", mas é inválido.");
    }
}
