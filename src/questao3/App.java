package questao3;

import questao2.entities.*;
import questao1.entities.Comida;

import java.util.Random;
import java.util.Scanner;

import questao1.exceptions.*;

public class App {
    public static void main(String[] args) {
        Random move = new Random();
        Scanner ler = new Scanner(System.in);
        Robo r1 = new RoboInteligente("Azul");
        Robo r2 = new Robo("Vermelho");
        Robo[] players = { r1, r2 };

        System.out.print("Digite as dimenções do tabuleiro: ");
        int linhas = ler.nextInt();
        int colunas = ler.nextInt();

        System.out.print("Digite as coordenadas da comida: ");
        int a = ler.nextInt();
        int b = ler.nextInt();
        Comida comida = new Comida(a - 1, b - 1);
        boolean condicao = true;
        Tabuleiro tab = new Tabuleiro(linhas, colunas, comida);
        while (condicao) {
            for (int j = 0; j < players.length; j++) {
                System.out.println("Vez do robô " + players[j].getCor());
                tab.mostrarTabuleiro(r1, r2);
                try {
                    Thread.sleep(3000);
                    players[j].movimentar(move.nextInt(1, 5), tab);
                    condicao = tab.ganhar(r1, r2);
                } catch (MovimentoInvalidoException | InterruptedException e) {
                    try {
                        int teste = Integer.parseInt(e.getMessage());
                        players[j].movimentar(move.nextInt(2, 5), tab);
                        condicao = tab.ganhar(r1, r2);
                    } catch (MovimentoInvalidoException f) {
                        try {
                            players[j].movimentar(move.nextInt(3, 5), tab);
                            condicao = tab.ganhar(r1, r2);
                        } catch (MovimentoInvalidoException g) {
                            try {
                                players[j].movimentar(move.nextInt(4, 5), tab);
                                condicao = tab.ganhar(r1, r2);
                            } catch (Exception h) {
                            }
                        }
                    } catch (NumberFormatException i) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        }
        ler.close();
    }
}
