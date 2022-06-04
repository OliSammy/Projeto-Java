package entities;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Comida comida = null;

    public Tabuleiro(int linhas, int colunas, Comida comida) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.comida = comida;
    }

    public void mostrarTabuleiro(Robo r1) {
        for (int i = 0; i <= linhas; i++) {
            for (int j = 0; j <= colunas; j++) {
                if (r1.getLinha() == i && r1.getColuna() == j) {
                    System.out.print(" R ");
                } else if (comida.getLinha() == i && comida.getColuna() == j) {
                    System.out.print(" C ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public boolean ganhar(Robo r1) {
        return r1.ganhar(comida);
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

}
