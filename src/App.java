import java.util.Scanner;

import entities.*;
import exceptions.MovimentoInvalidoException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Robo r1 = new Robo("Azul");

        System.out.println("Digite as coordenadas da comida: ");
        int a = ler.nextInt();
        int b = ler.nextInt();
        Comida comida = new Comida(a, b);

        Tabuleiro tab = new Tabuleiro(5, 5, r1, comida);
        String movimento = "";
        while (tab.ganhar()) {
            tab.mostrarTabuleiro();
            System.out.println("Digite o movimento que você deseja fazer: \n1.Up 2.Down 3.Right 4.Left\n");
            movimento = ler.next();
            try {
                tab.movimentarRobo(movimento);
            } catch (MovimentoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}
