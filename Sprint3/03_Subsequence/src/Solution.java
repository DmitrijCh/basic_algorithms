import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        int index = 0;
        for (int i = 0; i < str1.length(); i++) {
            boolean notfound = true;
            int x = index;
            for (; x < str2.length(); x++) {
                if (str1.charAt(i) == str2.charAt(x)) {
                    notfound = false;
                    break;
                }
            }
            if (notfound) {
                System.out.println("False");
                return;
            }
            index = x + 1;
        }
        System.out.println("True");
    }
}