package Strings;

import java.util.Stack;

/**
 * Reverse Words in a String
 * QUESTION: https://leetcode.com/problems/reverse-words-in-a-string/
 * OPTIMIZED ANS: https://leetcode.com/problems/reverse-words-in-a-string/submissions/944687045/
 * */

public class Reverse {
    public static void main(String[] args) {
        System.out.println("the sky is blue");
        System.out.println(reverseString("the sky is blue"));
        System.out.println(reverseString1("the sky is blue"));
    }

    public static String reverseString(String str) {
        char[] arr = str.toCharArray();
        Stack<String> stk = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == ' ' && sb.toString().trim().length() != 0) {
                stk.push(sb.toString().trim());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        while(!stk.isEmpty()) {
            sb.append(" " + stk.pop());
        }

        return sb.toString().trim();
    }

    public static String reverseString1(String s) {
        StringBuilder strs = new StringBuilder();
        int len = s.length();
        int position = len-1;
        char[] arr = s.toCharArray();
        int right;
        while ((right=getRightIndex(position, arr))!=-1) {
            int left = getLeftIndex(right, arr);
            putCharIntoStringBuilder(strs, left, right, arr);
            position = left;
        }
        return strs.toString();
    }

    static int getRightIndex(int position, char[] arr) {
        while (position >=0) {
            if (arr[position]!=' ') {
                return position;
            }
            position--;
        }
        return -1;
    }

    static int getLeftIndex(int right, char[] arr) {
        int left = right;
        while (left>=0) {
            if (arr[left]==' '){
                return left;
            }
            left--;
        }
        return left;
    }

    static void putCharIntoStringBuilder(StringBuilder strs, int left, int right, char[] arr) {
        if (strs.length()!=0) {
            strs.append(' ');
        }
        left++;
        while (left<=right) {
            strs.append(arr[left++]);
        }
    }
}