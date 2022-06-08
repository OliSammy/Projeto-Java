package questao3;

import questao2.entities.*;
import questao1.entities.Comida;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

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
                ArrayList<Integer> opcao = new ArrayList();
                opcao.add(1);
                opcao.add(2);
                opcao.add(3);
                opcao.add(4);
                System.out.println("Vez do robô " + players[j].getCor());
                tab.mostrarTabuleiro(r1, r2);
                try {
                    Thread.sleep(3000);
                    players[j].movimentar(opcao.get(move.nextInt(0, 4)), tab);
                    condicao = tab.ganhar(r1, r2);
                } catch (MovimentoInvalidoException | InterruptedException | IndexOutOfBoundsException e) {
                    try {
                        int temp = Integer.parseInt(e.getMessage());
                        opcao.remove(temp - 1);
                        players[j].movimentar(opcao.get(move.nextInt(0, 3)), tab);
                        condicao = tab.ganhar(r1, r2);
                    } catch (MovimentoInvalidoException f) {
                        try {
                            int temp = Integer.parseInt(f.getMessage());
                            opcao.remove(temp - 1);
                            players[j].movimentar(opcao.get(move.nextInt(0, 2)), tab);
                            condicao = tab.ganhar(r1, r2);
                        } catch (MovimentoInvalidoException g) {
                            try {
                                players[j].movimentar(opcao.get(0), tab);
                                condicao = tab.ganhar(r1, r2);
                            } catch (Exception h) {
                            }
                        }

                    } catch (NumberFormatException i) {
                        System.out.println(e.getMessage());
                    }
                }
                if (!condicao)
                    break;
            }
        }
        ler.close();
    }
}
