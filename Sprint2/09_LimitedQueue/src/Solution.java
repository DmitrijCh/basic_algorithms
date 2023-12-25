import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static final List<Integer> queue = new ArrayList<>();
    private static int queueLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandQuantity = Integer.parseInt(reader.readLine());
        queueLimit = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        String command;
        for (int i = 0; i < commandQuantity; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            command = tokenizer.nextToken();
            switch (command) {
                case ("push") -> push(Integer.parseInt(tokenizer.nextToken()));
                case ("pop") -> pop();
                case ("peek") -> peek();
                case ("size") -> size();
            }
        }
    }

    public static void push(int number) {
        if (queue.size() < queueLimit) {
            queue.add(0, number);
        } else {
            System.out.println("error");
        }
    }

    public static void pop() {
        if (queue.isEmpty()) {
            System.out.println("None");
            return;
        }
        System.out.println(queue.get(getTopIndex()));
        queue.remove(getTopIndex());
    }

    public static void peek() {
        if (queue.isEmpty()) {
            System.out.println("None");
            return;
        }
        System.out.println(queue.get(getTopIndex()));
    }

    public static void size() {
        System.out.println(queue.size());
    }

    private static int getTopIndex() {
        return queue.size() - 1;
    }
}