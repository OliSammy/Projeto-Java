package questao1.exceptions;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException() {
        super("Movimento inválido");
    }

    public MovimentoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public MovimentoInvalidoException(String outraMensagem, String mensagem) {
        super("O robô " + outraMensagem + " fez o movimento " + mensagem + ", mas é inválido.");
    }
}
