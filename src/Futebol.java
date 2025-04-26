package src;

import java.util.Scanner;

public class Futebol {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int totalJogadores = entrada.nextInt();
        int[] niveisHabilidade = capturarHabilidades(entrada, totalJogadores);
        entrada.close();

        int maiorTamanhoEquipe = calcularMaiorEquipe(niveisHabilidade);
        
        mostrarResultado(maiorTamanhoEquipe);
    }

    private static int[] capturarHabilidades(Scanner entrada, int quantidade) {
        int[] habilidades = new int[quantidade];
        for (int posicao = 0; posicao < quantidade; posicao++) {
            habilidades[posicao] = entrada.nextInt();
        }
        return habilidades;
    }

    private static int calcularMaiorEquipe(int[] habilidades) {
        ordenarMerge(habilidades, 0, habilidades.length - 1);
        
        int tamanhoMaximo = 1;
        int inicio = 0;

        for (int fim = 1; fim < habilidades.length; fim++) {
            while (habilidades[fim] - habilidades[inicio] > 5) {
                inicio++;
            }
            tamanhoMaximo = Math.max(tamanhoMaximo, fim - inicio + 1);
        }
        
        return tamanhoMaximo;
    }

    private static void ordenarMerge(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            ordenarMerge(vetor, inicio, meio);
            ordenarMerge(vetor, meio + 1, fim);
            
            combinar(vetor, inicio, meio, fim);
        }
    }

    private static void combinar(int[] vetor, int inicio, int meio, int fim) {
        int tamanhoEsq = meio - inicio + 1;
        int tamanhoDir = fim - meio;
        
        int[] ladoEsquerdo = new int[tamanhoEsq];
        int[] ladoDireito = new int[tamanhoDir];
        
        for (int i = 0; i < tamanhoEsq; i++) {
            ladoEsquerdo[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tamanhoDir; j++) {
            ladoDireito[j] = vetor[meio + 1 + j];
        }
        
        int i = 0, j = 0, k = inicio;
        
        while (i < tamanhoEsq && j < tamanhoDir) {
            if (ladoEsquerdo[i] <= ladoDireito[j]) {
                vetor[k] = ladoEsquerdo[i];
                i++;
            } else {
                vetor[k] = ladoDireito[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanhoEsq) {
            vetor[k] = ladoEsquerdo[i];
            i++;
            k++;
        }
        
        while (j < tamanhoDir) {
            vetor[k] = ladoDireito[j];
            j++;
            k++;
        }
    }

    private static void mostrarResultado(int tamanho) {
        System.out.println("Tamanho ideal do time: " + tamanho);
        System.out.println("Desempenho do algoritmo: O(n log n) no pior cenário");
    }
}
