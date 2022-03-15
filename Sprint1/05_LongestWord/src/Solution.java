import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int number = Integer.parseInt(tokenizer.nextToken());
        String line = bufferedReader.readLine();
        String[] array = line.split(" ");
        String chhar = array[0];
        for (int i = 1; i < array.length; i++) {
            if (chhar.length() < array[i].length())
                chhar = array[i];
        }
        System.out.println(chhar);
        System.out.println(chhar.length());
    }
}
