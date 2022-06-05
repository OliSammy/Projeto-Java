package entities;

import exceptions.MovimentoInvalidoException;

public class Robo {
    private int linha = 0, coluna = 0;

    private String cor;

    public Robo(String cor) {
        this.cor = cor;
    }

    public void movimentar(String movimento, Tabuleiro tabuleiro) throws MovimentoInvalidoException {
        switch (movimento.toUpperCase()) {
            case "UP":
                if (linha - 1 < 0) {
                    throw new MovimentoInvalidoException(movimento);
                }
                linha -= 1;
                break;
            case "DOWN":
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException();
                }
                linha += 1;
                break;
            case "RIGHT":
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
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
                if (linha + 1 > tabuleiro.getLinhas() - 1) {
                    throw new MovimentoInvalidoException("down");
                }
                linha += 1;
                break;
            case "D":
                if (coluna + 1 > tabuleiro.getColunas() - 1) {
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

    public boolean ganhar(Comida comida) {
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

}
