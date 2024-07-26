public class Palindrome {
    public static void main(String[] args) {
        String input = "race";
        String palindrome = generatePalindrome(input);
        System.out.println("Input String: " + input);
        System.out.println("Generated Palindrome: " + palindrome);
    }
    public static String generatePalindrome(String input) {
        if (isPalindrome(input)) {
            return input;
        }
        String reversed = new StringBuilder(input).reverse().toString();
        return input + reversed;
    }
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}