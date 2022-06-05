package questao2;

import java.util.Random;
import java.util.Scanner;

import questao1.entities.Comida;
import questao1.exceptions.*;

import questao2.entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Random movimento = new Random();
        Scanner ler = new Scanner(System.in);
        Robo r1 = new Robo("Azul");
        Robo r2 = new Robo("Vermelho", 1, 1);
        Robo[] players = { r1, r2 };

        System.out.print("Digite as dimenções do tabuleiro: ");
        int linhas = ler.nextInt();
        int colunas = ler.nextInt();

        System.out.print("Digite as coordenadas da comida: ");
        int a = ler.nextInt();
        int b = ler.nextInt();
        Comida comida = new Comida(a - 1, b - 1);

        Tabuleiro tab = new Tabuleiro(linhas, colunas, comida);
        while (tab.ganhar(r1, r2)) {
            for (int j = 0; j < players.length; j++) {
                System.out.println("Vez do robô " + players[j].getCor());
                tab.mostrarTabuleiro(r1, r2);
                try {
                    Thread.sleep(2000);
                    players[j].movimentar(movimento.nextInt(1, 5), tab);
                } catch (MovimentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        ler.close();
    }
}
