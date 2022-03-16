import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int a;
    private static int mod;
    private static long[] pows;
    private static long[] prefixHashes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(reader.readLine());
        mod = Integer.parseInt(reader.readLine());
        String string = reader.readLine();
        int t = Integer.parseInt(reader.readLine());
        powBase(string.length());
        hashPrefix(string);
        StringBuilder builder = new StringBuilder(" ");
        StringTokenizer stringTokenizer;
        for (int i = 0; i < t; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int left = Integer.parseInt(stringTokenizer.nextToken());
            int right = Integer.parseInt(stringTokenizer.nextToken());
            builder.append(hash_substring(left, right)).append("\n");
        }
        System.out.println(builder);
    }

    public static long hash_substring(int l, int r) {
        return Math.floorMod(prefixHashes[r] - prefixHashes[l - 1] * pows[r - (l - 1)], mod);
    }

    private static void powBase(int len) {
        pows = new long[len + 1];
        pows[0] = 1;
        for (int i = 1; i < pows.length; i++) {
            pows[i] = (pows[i - 1] * a) % mod;
        }
    }

    private static void hashPrefix(String string) {
        int len = string.length();
        prefixHashes = new long[len + 1];
        prefixHashes[0] = 0;
        for (int i = 1; i <= len; i++) {
            prefixHashes[i] = (prefixHashes[i - 1] * a % mod + string.charAt(i - 1)) % mod;
        }
    }
}