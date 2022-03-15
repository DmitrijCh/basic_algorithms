import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] arrR = new int[size];
        int number = 1000000;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == 0) {
                number = 0;
            } else {
                number += 1;
            }
            arrR[i] = number;
        }

        number = 1000000;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < size; j++) {
            if (array[j] == 0) {
                number = 0;
            } else {
                number += 1;
            }
            int s = Math.min(number, arrR[j]);
            builder.append(s).append(" ");
        }
        System.out.println(builder);
    }
}
