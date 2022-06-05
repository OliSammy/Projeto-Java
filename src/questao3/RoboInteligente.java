package questao3;

import questao2.entities.Robo;
import questao2.entities.Tabuleiro;
import questao1.exceptions.*;

public class RoboInteligente extends Robo {

    public RoboInteligente(String cor) {
        super(cor);
    }

    public RoboInteligente(String cor, int linha, int coluna) {
        super(cor, linha, coluna);
    }

    @Override
    public void movimentar(int movimento, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        switch (movimento) {
            case 1:
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException("1");
                }
                linha -= 1;
                break;
            case 3:
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException("3");
                }
                linha += 1;
                break;
            case 4:
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException("4");
                }
                coluna += 1;
                break;
            case 2:
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException("2");
                }
                coluna -= 1;
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }

}