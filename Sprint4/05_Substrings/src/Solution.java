import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int n = string.length();
        int curLen = 1;
        int maxLen = 1;
        int prevIndex;
        int i;
        int[] visited = new int[NO_OF_CHARS];
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        visited[string.charAt(0)] = 0;
        for (i = 1; i < n; i++) {
            prevIndex = visited[string.charAt(i)];
            if (prevIndex == -1 || i - curLen > prevIndex) {
                curLen++;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - prevIndex;
            }
            visited[string.charAt(i)] = i;
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        System.out.println(maxLen);
    }
}
