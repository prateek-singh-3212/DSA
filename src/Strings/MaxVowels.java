package Strings;

public class MaxVowels {
    public static void main(String[] args) {
        String t1 = "abciiidef";
        int kt1 = 3;

        System.out.println(maxVowels(t1, kt1));
    }

    public static int maxVowels(String s, int k) {
        // ---------Approach 1: Sliding Window---------------
        char[] arr = s.toCharArray();
        int max = 0;
        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            if(i<k) {
                // Within window...
                if(isVowel(arr[i])) {
                    max++;
                    ans = max;
                }
                continue;
            }
            if(isVowel(arr[i]) && !isVowel(arr[i-k])) {
                max++;
                ans = Math.max(max, ans);
            }else if(!isVowel(arr[i]) && isVowel(arr[i-k])) {
                max--;
                ans = Math.max(max, ans);
            }
        }

        return ans;
    }

    private static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
