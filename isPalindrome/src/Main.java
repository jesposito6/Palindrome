import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Long> list;

    public static void main(String[] args) {
        list = new ArrayList<>();

        // Run tests with a base of 10 up to 100 million
        for(int i = 1; i <= 100000000; i *= 10){
            test(i);
        }
    }

    // Determines if string is a palindrome and records algorithm runtime
    public static boolean isPalindrome(String s){
        long start = System.currentTimeMillis();

        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1)){
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
    public static void test(int n){
        String s = "a".repeat(n);
        System.out.println("Test " + list.size() + " (size " + n + "): " + isPalindrome(s) + " time: " + list.get(list.size() - 1));
    }
}
