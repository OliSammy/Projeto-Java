package questao2.entities;

import questao1.exceptions.*;
import questao1.entities.Comida;

public class Robo {
    protected int linha = 0, coluna = 0;
    protected int jogadas = 0;
    protected String cor;

    public Robo(String cor) {
        this.cor = cor;
    }

    public Robo(String cor, int linha, int coluna) {
        this(cor);
        this.linha = linha;
        this.coluna = coluna;
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
                    throw new MovimentoInvalidoException(i);
                }
                linha += 1;
                break;
            case "RIGHT":
                if (coluna + 1 > tab.getColunas() - 1) {
                    throw new MovimentoInvalidoException(i);
                }
                coluna += 1;
                break;
            case "LEFT":
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException(i);
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
                    throw new MovimentoInvalidoException(cor, "up");
                }
                linha -= 1;
                break;
            case 3:
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException(cor, "down");
                }
                linha += 1;
                break;
            case 4:
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException(cor, "right");
                }
                coluna += 1;
                break;
            case 2:
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException(cor, "left");
                }
                coluna -= 1;
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }

    public boolean ganhar(Comida comida) {
        this.jogadas += 1;

        if (linha == comida.getLinha() && coluna == comida.getColuna()) {
            System.out.println("O robo " + cor + " ganhou!");
            return false;
        }
        return true;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha += linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna += coluna;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

}
