package questao1.entities;

public class Comida {
    private int linhas, colunas;

    public Comida(int x, int y) {
        this.linhas = x;
        this.colunas = y;
    }

    public int getLinha() {
        return linhas;
    }

    public void setLinha(int linhas) {
        this.linhas = linhas;
    }

    public int getColuna() {
        return colunas;
    }

    public void setColuna(int colunas) {
        this.colunas = colunas;
    }

}
