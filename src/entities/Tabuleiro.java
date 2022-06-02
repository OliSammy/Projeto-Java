package entities;

import exceptions.*;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Robo r1 = null;
    private Comida comida = null;

    public Tabuleiro(int linhas, int colunas, Robo r1, Comida comida) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.r1 = r1;
        this.comida = comida;
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                if (r1.getColuna() == i && r1.getLinha() == j) {
                    System.out.print(" R ");
                } else if (comida.getColuna() == i && comida.getLinha() == j) {
                    System.out.print(" C ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public void movimentarRobo(String movimento) throws MovimentoInvalidoException {
        switch (movimento) {
            case "Up":
                if (r1.getColuna() - 1 < 0) {
                    throw new MovimentoInvalidoException(movimento);
                }
                r1.setColuna(-1);
                break;
            case "Down":
                if (r1.getColuna() + 1 > colunas - 1) {
                    throw new MovimentoInvalidoException();
                }
                r1.setColuna(1);
                break;
            case "Right":
                if (r1.getLinha() + 1 > linhas - 1) {
                    throw new MovimentoInvalidoException();
                }
                r1.setLinha(1);
                break;
            case "Left":
                if (r1.getLinha() - 1 < 0) {
                    throw new MovimentoInvalidoException();
                }
                r1.setLinha(-1);
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }

    public void movimentarRobo(int movimento) throws MovimentoInvalidoException {
        switch (movimento) {
            case 1:
                if (r1.getColuna() - 1 < 0) {
                    throw new MovimentoInvalidoException("Up");
                }
                r1.setColuna(-1);
                break;
            case 2:
                if (r1.getColuna() + 1 > colunas - 1) {
                    throw new MovimentoInvalidoException("Down");
                }
                r1.setColuna(1);
                break;
            case 3:
                if (r1.getLinha() + 1 > linhas - 1) {
                    throw new MovimentoInvalidoException("Left");
                }
                r1.setLinha(1);
                break;
            case 4:
                if (r1.getLinha() - 1 < 0) {
                    throw new MovimentoInvalidoException("Right");
                }
                r1.setLinha(-1);
                break;
            default:
                System.out.println("Movimento inválido");
        }
    }

    public boolean ganhar() {
        if (r1.getLinha() == comida.getLinha() && r1.getColuna() == comida.getColuna()) {
            System.out.println("Você ganhou! : )");
            return false;
        }
        return true;
    }

}
