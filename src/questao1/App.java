package questao1;

import java.util.Scanner;

import questao1.entities.*;
import questao1.exceptions.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Robo r1 = new Robo("Azul");

        System.out.print("Digite as dimenções do tabuleiro: (X Y)");
        int linhas = ler.nextInt();
        int colunas = ler.nextInt();

        System.out.print("Digite as coordenadas da comida: (X Y)");
        int a = ler.nextInt();
        int b = ler.nextInt();
        Comida comida = new Comida(a - 1, b - 1);

        Tabuleiro tab = new Tabuleiro(linhas, colunas, comida);
        String i = "";
        System.out.println("\n\nBem vindo ao game. Capture o C");
        while (tab.ganhar(r1)) {
            tab.mostrarTabuleiro(r1);
            try {
                i = ler.next();
                int j = Integer.parseInt(i);
                r1.movimentar(j, tab);
                Thread.sleep(3000);
            } catch (NumberFormatException e) {
                try {
                    r1.movimentar(i, tab);
                } catch (MovimentoInvalidoException f) {
                    System.out.println(f.getMessage());
                }
            } catch (MovimentoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        ler.close();
    }
}
