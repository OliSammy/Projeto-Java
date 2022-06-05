package questao3;
import questao2.entities.Robo;
import questao2.entities.Tabuleiro;
import questao1.exceptions.*;

public class RoboInteligente extends Robo{

    public RoboInteligente(String cor) {
        super(cor);
    }

    public RoboInteligente(String cor, int linha, int coluna){
        super(cor, linha, coluna);
    }

    public void movimentar(String i, Tabuleiro tab) throws MovimentoInvalidoException {
        switch (i.toUpperCase()) {
            case "UP":
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException(i);
                }
                linha -= 1;
                break;
            case "DOWN":
                if (linha + 1 > tab.getLinhas() - 1) {
                    throw new MovimentoInvalidoException();
                }
                linha += 1;
                break;
            case "RIGHT":
                if (coluna + 1 > tab.getColunas() - 1) {
                    throw new MovimentoInvalidoException();
                }
                coluna += 1;
                break;
            case "LEFT":
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException();
                }
                coluna -= 1;
                break;
            case "W":
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException("up");
                }
                linha -= 1;
                break;
            case "S":
                if (linha + 1 > tab.getLinhas() - 1) {
                    throw new MovimentoInvalidoException("down");
                }
                linha += 1;
                break;
            case "D":
                if (coluna + 1 > tab.getColunas() - 1) {
                    throw new MovimentoInvalidoException("right");
                }
                coluna += 1;
                break;
            case "A":
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException("left");
                }
                coluna -= 1;
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }

    public void movimentar(int movimento, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        switch (movimento) {
            case 1:
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException("up");
                }
                linha -= 1;
                break;
            case 3:
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException("down");
                }
                linha += 1;
                break;
            case 4:
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException("right");
                }
                coluna += 1;
                break;
            case 2:
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException("left");
                }
                coluna -= 1;
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }





}