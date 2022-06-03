package questao1.exceptions;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException() {
        super("Movimento inválido");
    }

    public MovimentoInvalidoException(String mensagem) {
        super("Movimento " + mensagem + " inválido");
    }
}
