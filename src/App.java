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

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> System.out.println(Arrays.toString(ex01()));
                case 2 -> System.out.println(Arrays.toString(ex02()));
                case 3 -> System.out.println(Arrays.toString(ex03()));
                case 4 -> {
                    int[] v = ex04();
                    System.out.println(Arrays.toString(v));
                    System.out.println("Soma: " + calcularSoma(v));
                }
                case 5 -> exibirMatriz(ex05());
                case 6 -> {
                    int[][][] m = ex06();
                    System.out.println("Matriz Soma:");
                    exibirMatriz(m[2]);
                }
            }
        }
    }

    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            while (!scanner.hasNextInt()) { scanner.next(); }
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
        if (valor <= 1 || valor >= 100) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) N[i] = N[i - 1] + 1;
        return N;
    }

    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        if (vetor == null) return 0;
        for (int v : vetor) soma += v;
        return soma;
    }

    public static int[][] matrizIncrementais(int valor) {
        if (valor <= 3 || valor > 50) return null;
        int[][] N = new int[valor][valor];
        int contador = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) N[i][j] = contador++;
        }
        return N;
    }

    public static int[][][] operacaoEntreMatrizes(int valor) {
        if (valor <= 3 || valor > 50) return null;
        int[][] n = new int[valor][valor];
        int[][] z = new int[valor][valor];
        int[][] s = new int[valor][valor];
        int c = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) {
                n[i][j] = z[i][j] = c;
                s[i][j] = c + c;
                c++;
            }
        }
        return new int[][][] { n, z, s };
    }

    public static int[] ex01() { return progressaoGeometrica(lerValor(new Scanner(System.in), "Valor <= 20: ", -100, 20)); }
    public static int[] ex02() { return sequenciaDecrescente(lerValor(new Scanner(System.in), "Valor (1 < v < 100): ", 1, 99)); }
    public static int[] ex03() { return vetorDinamico(lerValor(new Scanner(System.in), "Tamanho (1 a 1000): ", 0, 1000)); }
    public static int[] ex04() { return sequenciaCresenteComSoma(lerValor(new Scanner(System.in), "Valor (1 < v < 100): ", 1, 99)); }
    public static int[][] ex05() { return matrizIncrementais(lerValor(new Scanner(System.in), "Tamanho (3 a 50): ", 3, 50)); }
    public static int[][][] ex06() { return operacaoEntreMatrizes(lerValor(new Scanner(System.in), "Tamanho (3 a 50): ", 3, 50)); }
}