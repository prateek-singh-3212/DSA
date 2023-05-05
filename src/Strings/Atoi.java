package Strings;

public class Atoi {
    public static void main(String[] args) {
        System.out.println("String: 42 " + myAtoi("42-43"));
    }

    /*
    Steps:
    1. Ingnore Whitespace.
    2. Check the number is '-' or '+'
    3. Extract the number from string.
    4. Remove all leading zero from the integer.
    */
    public static int myAtoi(String s) {

        char[] arr = s.trim().toCharArray();
        int ans = 0;
        int tense = 0;
        boolean flag = false;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '-' && i+1 < arr.length && arr[i+1] != ' ') {
                // Then preceeding this might be a number...
                ans = -1;
                flag = true;
            }else {
                flag = false;
            }

            if(arr[i] == '+' && i+1 < arr.length && arr[i+1] != ' ') {
                // Then preceeding this might be a number...
                ans = +1;
                flag = true;
            }else {
                flag = false;
            }

            if(isNumber(arr[i])) {
                if (ans == 0) {
                    ans = (arr[i] - '0')*(int)Math.pow(10, tense);
                }else {
                    ans = ans + (arr[i] - '0')*(int)Math.pow(10, tense);
                }
                tense++;
            }else if(flag) {
                // Flag is true but char is not a number...reset
                ans = 0;
                break;
            }
        }

        return ans;
    }

    private static boolean isNumber(char c) {
        if(c >= '0' && c <= '9') {
            // Then it is number...
            return true;
        }
        return false;
    }
}
