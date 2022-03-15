import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int[][] transMatrix = new int[m][n];

        toTransport(n, m, matrix, transMatrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(transMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static void toTransport(int n, int m, int[][] matrix, int[][] transMatrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transMatrix[i][j] = matrix[j][i];
            }
        }
    }
}