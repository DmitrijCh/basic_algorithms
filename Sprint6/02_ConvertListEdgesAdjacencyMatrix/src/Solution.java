import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vertexQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int edgeQuantity = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[vertexQuantity][vertexQuantity];
        for (int i = 0; i < edgeQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstVertex = Integer.parseInt(stringTokenizer.nextToken());
            int secondVertex = Integer.parseInt(stringTokenizer.nextToken());
            matrix[firstVertex - 1][secondVertex - 1] = 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vertexQuantity; i++) {
            for (int j = 0; j < vertexQuantity; j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
