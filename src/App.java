import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Progressao Geometrica");
            System.out.println("2 - Sequencia Decrescente");
            System.out.println("3 - Vetor Dinamico");
            System.out.println("4 - Sequencia Crescente com Soma");
            System.out.println("5 - Matriz com Valores Incrementais");
            System.out.println("6 - Operacao entre Matrizes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada invalida. Escolha uma opcao: ");
                scanner.next();
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: System.out.println(Arrays.toString(ex01())); break;
                case 2: System.out.println(Arrays.toString(ex02())); break;
                case 3: System.out.println(Arrays.toString(ex03())); break;
                case 4: {
                    int[] v = ex04();
                    System.out.println(Arrays.toString(v));
                    System.out.println("Soma: " + calcularSoma(v));
                    break;
                }
                case 5: exibirMatriz(ex05()); break;
                case 6: {
                    int[][][] m = ex06();
                    System.out.println("Matriz N:"); exibirMatriz(m[0]);
                    System.out.println("Matriz Z:"); exibirMatriz(m[1]);
                    System.out.println("Matriz Soma:"); exibirMatriz(m[2]);
                    break;
                }
                case 0: System.out.println("Encerrando o programa."); break;
                default: System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }

    // --- MÉTODOS AUXILIARES REQUERIDOS ---
    
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada invalida. " + mensagem);
                scanner.next();
            }
            valor = scanner.nextInt();
        } while (valor <= min || valor > max);
        return valor;
    }

    private static void exibirMatriz(int[][] matriz) {
        if (matriz == null) return;
        for (int[] linha : matriz) {
            for (int v : linha) System.out.printf("%4d ", v);
            System.out.println();
        }
    }

    // --- LOGICA DOS EXERCICIOS ---

    public static int[] progressaoGeometrica(int valor) {
        if (valor > 20) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) N[i] = N[i - 1] * 2;
        return N;
    }

    public static int[] sequenciaDecrescente(int valor) {
        if (valor <= 1) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) N[i] = N[i - 1] - 1;
        return N;
    }

    public static int[] vetorDinamico(int valor) {
        if (valor > 1000 || valor <= 0) return null;
        int[] N = new int[valor];
        for (int i = 0; i < valor; i++) N[i] = i + 1;
        return N;
    }

    public static int[] sequenciaCresenteComSoma(int valor) {
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) N[i] = N[i - 1] + 1;
        return N;
    }

    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int v : vetor) soma += v;
        return soma;
    }

    public static int[][] matrizIncrementais(int valor) {
        int[][] N = new int[valor][valor];
        int contador = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) N[i][j] = contador++;
        }
        return N;
    }

    public static int[][][] operacaoEntreMatrizes(int valor) {
        int[][] matN = new int[valor][valor];
        int[][] matZ = new int[valor][valor];
        int[][] matSoma = new int[valor][valor];
        int contador = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) {
                matN[i][j] = matZ[i][j] = contador;
                matSoma[i][j] = contador + contador;
                contador++;
            }
        }
        return new int[][][] { matN, matZ, matSoma };
    }

    // --- MÉTODOS REQUERIDOS PELO AUTOGRADER (NÃO REMOVER) ---

    public static int[] ex01() {
        int v = lerValor(new Scanner(System.in), "Informe um valor <= 20: ", -1000, 20);
        return progressaoGeometrica(v);
    }

    public static int[] ex02() {
        int v = lerValor(new Scanner(System.in), "Informe um valor entre 1 e 100: ", 1, 99);
        return sequenciaDecrescente(v);
    }

    public static int[] ex03() {
        int v = lerValor(new Scanner(System.in), "Informe um valor entre 1 e 1000: ", 0, 1000);
        return vetorDinamico(v);
    }

    public static int[] ex04() {
        int v = lerValor(new Scanner(System.in), "Informe um valor entre 1 e 100: ", 1, 99);
        return sequenciaCresenteComSoma(v);
    }

    public static int[][] ex05() {
        int v = lerValor(new Scanner(System.in), "Informe um valor entre 3 e 50: ", 3, 50);
        return matrizIncrementais(v);
    }

    public static int[][][] ex06() {
        int v = lerValor(new Scanner(System.in), "Informe um valor entre 3 e 50: ", 3, 50);
        return operacaoEntreMatrizes(v);
    }
}