import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] num = reader.readLine().split(" ");
        int a = Integer.parseInt(num[0]);
        int x = Integer.parseInt(num[1]);
        int b = Integer.parseInt(num[2]);
        int c = Integer.parseInt(num[3]);
        int y = a * (x * x) + (b * x) + c;
        builder.append(y).append("\n");
        System.out.println(builder);
    }
}