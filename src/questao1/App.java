package questao1;

import java.util.Scanner;

import questao1.entities.*;
import questao1.exceptions.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Robo r1 = new Robo("Azul");
        System.out.print("Digite as dimenções do tabuleiro: (X Y) ");
        int linhas = ler.nextInt();
        int colunas = ler.nextInt();
        System.out.print("Digite as coordenadas da comida: (X Y) ");
        int a = ler.nextInt();
        int b = ler.nextInt();
        boolean erro=true;
        while(erro){ if(a>linhas || b>colunas ||a<=1 || b<=1){
            System.out.println("Coordenadas Invalidas,digite novamente");
            System.out.print("Digite as coordenadas da comida: (X Y) ");
            a = ler.nextInt(); 
            b = ler.nextInt();
            }else{
                erro=false;
            }
        
        }
        Comida comida = new Comida(a - 1, b - 1);

        Tabuleiro tab = new Tabuleiro(linhas, colunas, comida);
        String i = "";
        System.out.println("\n\nBem vindo ao game. Capture o C");

        tab.mostrarTabuleiro(r1);

        while (tab.ganhar(r1)) {
            
            System.out.println("1-Up  2-Down  3-Right  4-Left");

            try {
                i = ler.next();
                int j = Integer.parseInt(i);
                r1.movimentar(j, tab);
            } catch (NumberFormatException e) {
                try {
                    r1.movimentar(i, tab);
                } catch (MovimentoInvalidoException f) {
                    System.out.println(f.getMessage());
                }
            } catch (MovimentoInvalidoException e) {
                System.out.println(e.getMessage());
            }

            tab.mostrarTabuleiro(r1);
            

        }
        ler.close();
    }
}
