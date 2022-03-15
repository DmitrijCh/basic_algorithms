// Сложность алгоритма: O(n) — линейная зависимость

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int streetLength = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        final int maxStreetLength = 1000000;
        int street = maxStreetLength;
        int[] houseNumbers = new int[streetLength];
        for (int i = 0; i < streetLength; i++) {
            houseNumbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] passArrayRight = new int[streetLength];
        for (int i = streetLength - 1; i >= 0; i--) {
            if (houseNumbers[i] == 0) {
                street = 0;
            } else {
                street += 1;
            }
            passArrayRight[i] = street;
        }

        street = maxStreetLength;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < streetLength; j++) {
            if (houseNumbers[j] == 0) {
                street = 0;
            } else {
                street += 1;
            }
            int smallNumber = Math.min(street, passArrayRight[j]);
            builder.append(smallNumber).append(" ");
        }
        System.out.println(builder);
    }
}
