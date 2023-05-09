package Strings;

public class Atoi {
    public static void main(String[] args) {
        System.out.println("" + myAtoi("-2147483647"));
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
        long ans = 0;
        boolean flag = false;
        boolean isNegative = false;
        boolean isString = false;

        for(int i=0; i<arr.length; i++) {

            if(isNumber(arr[i]) && !isString) {
                // Read the number
                ans = ans*10 + (arr[i] - '0');
                if(isNegative && (-1*ans) <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }else if(!isNegative && ans >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                flag = true;
            }else if(flag) {
                // Flag is true but char is not a number...reset
                break;
            }

            if(arr[i] == '-' && i+1 < arr.length && isNumber(arr[i+1])) {
                // Then preceeding this might be a number...
                isNegative = true;
                flag = true;
            }else if(arr[i] == '+' && i+1 < arr.length && isNumber(arr[i+1])) {
                // Then preceeding this might be a number...
                isNegative = false;
                flag = true;
            }else if (arr[i] != ' ' && !isNumber(arr[i])) {
                isString = true;
            }
        }

        return (int) ((isNegative) ? -1*ans : ans);
    }

    private static boolean isNumber(char c) {
        if(c >= '0' && c <= '9') {
            // Then it is number...
            return true;
        }
        return false;
    }
}
