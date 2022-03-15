import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        input = input.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        if (input.equalsIgnoreCase((new StringBuilder(input)).reverse().toString())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
