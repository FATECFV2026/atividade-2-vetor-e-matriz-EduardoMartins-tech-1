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
                case 1: {
                    int valor;
                    do {
                        System.out.print("Informe um valor <= 20: ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor > 20);
                    int[] resultado = progressaoGeometrica(valor);
                    if (resultado != null) System.out.println(Arrays.toString(resultado));
                    break;
                }
                case 2: {
                    int valor;
                    do {
                        System.out.print("Informe um valor entre 1 e 100 (nao inclusos): ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor <= 1 || valor >= 100);
                    int[] resultado = sequenciaDecrescente(valor);
                    if (resultado != null) System.out.println(Arrays.toString(resultado));
                    break;
                }
                case 3: {
                    int valor;
                    do {
                        System.out.print("Informe um valor entre 1 e 1000: ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor <= 1 || valor > 1000);
                    int[] resultado = vetorDinamico(valor);
                    if (resultado != null) System.out.println(Arrays.toString(resultado));
                    break;
                }
                case 4: {
                    int valor;
                    do {
                        System.out.print("Informe um valor entre 1 e 100 (nao inclusos): ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor <= 1 || valor >= 100);
                    int[] vetor = sequenciaCresenteComSoma(valor);
                    if (vetor != null) {
                        System.out.println(Arrays.toString(vetor));
                        System.out.println("Soma: " + calcularSoma(vetor));
                    }
                    break;
                }
                case 5: {
                    int valor;
                    do {
                        System.out.print("Informe um valor entre 3 e 50: ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor <= 3 || valor > 50);
                    int[][] matriz = matrizIncrementais(valor);
                    if (matriz != null) {
                        for (int[] linha : matriz) {
                            for (int v : linha) System.out.printf("%4d ", v);
                            System.out.println();
                        }
                    }
                    break;
                }
                case 6: {
                    int valor;
                    do {
                        System.out.print("Informe um valor entre 3 e 50: ");
                        while (!scanner.hasNextInt()) { scanner.next(); }
                        valor = scanner.nextInt();
                    } while (valor <= 3 || valor > 50);
                    int[][][] matrizes = operacaoEntreMatrizes(valor);
                    if (matrizes != null) {
                        String[] nomes = {"Matriz N", "Matriz Z", "Matriz Soma"};
                        for (int m = 0; m < 3; m++) {
                            System.out.println(nomes[m] + ":");
                            for (int[] linha : matrizes[m]) {
                                for (int v : linha) System.out.printf("%4d ", v);
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }

        scanner.close();
    }

    // Ex01: retorna int[10] com PG (dobro); null se entrada > 20
    public static int[] progressaoGeometrica(int valor) {
        if (valor > 20) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) {
            N[i] = N[i - 1] * 2;
        }
        return N;
    }

    // Ex02: retorna int[10] decrescente (-1 por posição); null se entrada <= 1
    public static int[] sequenciaDecrescente(int valor) {
        if (valor <= 1) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) {
            N[i] = N[i - 1] - 1;
        }
        return N;
    }

    // Ex03: retorna int[N] com [1..N]; null se entrada > 1000
    public static int[] vetorDinamico(int valor) {
        if (valor > 1000) return null;
        int[] N = new int[valor];
        for (int i = 0; i < valor; i++) {
            N[i] = i + 1;
        }
        return N;
    }

    // Ex04: retorna int[10] crescente (+1); null se fora do range
    public static int[] sequenciaCresenteComSoma(int valor) {
        if (valor <= 1 || valor >= 100) return null;
        int[] N = new int[10];
        N[0] = valor;
        for (int i = 1; i < 10; i++) {
            N[i] = N[i - 1] + 1;
        }
        return N;
    }

    // Ex04: calcula soma de todos os elementos do vetor
    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int v : vetor) soma += v;
        return soma;
    }

    // Ex05: matriz NxN com valores incrementais começando em valor+1
    public static int[][] matrizIncrementais(int valor) {
        if (valor <= 3 || valor > 50) return null;
        int[][] N = new int[valor][valor];
        int contador = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) {
                N[i][j] = contador++;
            }
        }
        return N;
    }

    // Ex06: retorna int[3][N][N] — índice 0=N, 1=Z, 2=Soma
    public static int[][][] operacaoEntreMatrizes(int valor) {
        if (valor <= 3 || valor > 50) return null;
        int[][] matN   = new int[valor][valor];
        int[][] matZ   = new int[valor][valor];
        int[][] matSoma = new int[valor][valor];
        int contador = valor + 1;
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) {
                matN[i][j]    = contador;
                matZ[i][j]    = contador;
                matSoma[i][j] = contador + contador;
                contador++;
            }
        }
        return new int[][][] { matN, matZ, matSoma };
    }
}