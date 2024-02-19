import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Long> list;

    public static void main(String[] args) {
        list = new ArrayList<>();

        // Run tests with a base of 10 up to 100 million
        System.out.println("GUARANTEED PALINDROME");
        for(int i = 1; i <= 100000000; i *= 10){
            String s = "a".repeat(i);
            test(s, i);
        }

        System.out.println();

        System.out.println("NON-PALINDROME TEST");
        for(int i = 1; i <= 100000000; i *= 10){
            String s = "a".repeat(i - 1);
            s += 'b';

            test(s, i);
        }

        System.out.println();

        System.out.println("RANDOM STRING TEST");
        for(int i = 1; i <= 100000000; i *= 10){
            StringBuilder s = new StringBuilder();

            for(int j = 1; j <= i; j++){
                s.append((char) ((int) (Math.random() * 26) + 'a'));
            }

            test(s.toString(), i);
        }
    }

    // Determines if string is a palindrome and records algorithm runtime
    public static boolean isPalindrome(String s){
        long start = System.currentTimeMillis();

        for(int i = 0; i < s.length()/2; i++){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(s.length() - i - 1))){
                long end = System.currentTimeMillis();
                list.add(end - start);
                return false;
            }
        }

        long end = System.currentTimeMillis();
        list.add(end - start);
        return true;
    }

    // Helper for printing results
    public static void test(String s, int n){
        System.out.println("Test " + list.size() + " (size " + n + "): " + isPalindrome(s) + " time: " + list.get(list.size() - 1));
    }
}
