import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static ArrayList<Integer> stack = new ArrayList<>();
    public static ArrayList<Integer> max = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandQuantity = Integer.parseInt(reader.readLine());
        int number;
        for (int i = 0; i < commandQuantity; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            switch (command) {
                case "push" -> {
                    number = Integer.parseInt(tokenizer.nextToken());
                    push(number);
                }
                case "pop" -> pop();
                case "get_max" -> get_max();
            }
        }
    }

    public static void push(int number) {
        stack.add(number);
        if (max.size() == 0) {
            max.add(number);
        } else {
            int currentMax = max.get(max.size() - 1);
            max.add(Math.max(number, currentMax));
        }
    }

    public static void pop() {
        if (stack.size() == 0) {
            System.out.println("error");
            return;
        }
        stack.remove(stack.size() - 1);
        max.remove(max.size() - 1);
    }

    public static void get_max() {
        if (stack.size() == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(max.get(max.size() - 1));
    }
}
