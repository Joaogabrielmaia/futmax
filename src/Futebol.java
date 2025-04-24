package src;

import java.util.Scanner;

public class Futebol {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        int[] skills = new int[n];
        
        for (int i = 0; i < n; i++) {
            skills[i] = leitor.nextInt();
        }
        leitor.close();
        
        int maxTeamSize = maiorTimePossivel(skills);
        System.out.println(maxTeamSize);
    }

    private static int maiorTimePossivel(int[] skills) {
        if (skills.length == 0) return 0;
        
        mergeSort(skills, 0, skills.length - 1);
        
        int maxSize = 1;
        int left = 0;
        
        for (int right = 0; right < skills.length; right++) {
            while (skills[right] - skills[left] > 5) {
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }
        
        return maxSize;
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}