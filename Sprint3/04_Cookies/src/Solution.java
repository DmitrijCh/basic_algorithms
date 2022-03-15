import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int childrenQuantity = Integer.parseInt(reader.readLine());
        List<Integer> child = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < childrenQuantity; i++) {
            child.add(Integer.parseInt(tokenizer.nextToken()));
        }

        List<Integer> cookies = new ArrayList<>();
        int cookiesQuantity = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < cookiesQuantity; i++) {
            cookies.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Collections.sort(child);
        Collections.sort(cookies);

        int childrenIndex = 0;
        int cookieIndex = 0;
        int result = 0;
        while (childrenIndex < childrenQuantity && cookieIndex < cookiesQuantity) {
            if (child.get(childrenIndex) <= cookies.get(cookieIndex)) {
                result++;
                childrenIndex++;
            }
            cookieIndex++;
        }
        System.out.println(result);
    }
}