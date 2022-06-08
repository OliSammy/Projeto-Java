package questao1.entities;

import questao1.exceptions.*;

public class Robo {
    private int linha = 0, coluna = 0;
    private String cor;
    private int jogadas;

    public Robo(String cor) {
        this.cor = cor;
    }

    public void movimentar(String i, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        switch (i.toUpperCase()) {
            case "UP":
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException(cor, i);
                }
                linha -= 1;
                break;
            case "DOWN":
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException(cor, i);
                }
                linha += 1;
                break;
            case "RIGHT":
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException(cor, i);
                }
                coluna += 1;
                break;
            case "LEFT":
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException(cor, i);
                }
                coluna -= 1;
                break;
            case "W":
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException(cor, "up");
                }
                linha -= 1;
                break;
            case "S":
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException(cor, "down");
                }
                linha += 1;
                break;
            case "D":
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException(cor, "right");
                }
                coluna += 1;
                break;
            case "A":
                if (coluna - 1 < 0) {
                    throw new MovimentoInvalidoException(cor, "left");
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
            case 2:
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException(cor, "down");
                }
                linha += 1;
                break;
            case 3:
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
                    throw new MovimentoInvalidoException(cor, "right");
                }
                coluna += 1;
                break;
            case 4:
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
        jogadas += 1;
        if (linha == comida.getLinha() && coluna == comida.getColuna()) {
            System.out.println("O robo " + cor + " ganhou, realizando " + jogadas + " jogadas.");
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

    public void setCor(String cor) {
        this.cor = cor;
    }

}
