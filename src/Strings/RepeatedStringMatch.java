package Strings;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "baaa";
        String b = "aabaab";
        System.out.println(repeatedStringMatch(a, b));
    }

    public static int repeatedStringMatch(String a, String b) {
        int count = 0;
        if (a.length() >= b.length()) {
            int ans = naive(a, b);
            int ans2 = naive(a+a, b);
            if (ans == -1 && ans2 == -1) {
                return -1;
            }else if (ans != -1){
                return 1;
            }else {
                return 2;
            }
        }

        int firstOccurance = naive(b, a);
        if(firstOccurance == -1) {
            return -1;
        }else {
            count += 1;
        }

        String suffixString = b.substring(0, firstOccurance);
        if (suffixString.length() != 0) {
            int suffix = naive(a, suffixString);
            if(suffix  == -1 || (suffix + suffixString.length()) != a.length()) {
                return -1;
            }else {
                count += 1;
            }
        }

        int nextOccurance = firstOccurance + a.length();
        while (nextOccurance + a.length() <= b.length()) {
            int temp = naive(b.substring(nextOccurance, nextOccurance + a.length()), a);
            if (temp == -1) {
                return -1;
            }
            count++;
            nextOccurance = nextOccurance + a.length();
        }

        if (nextOccurance != b.length()) {
            // Check prefix...
            String prefixString = b.substring(nextOccurance);
            int prefix = naive(a, prefixString);
            if (prefix != 0) {
                return -1;
            }else {
                count++;
            }
        }

        return count;
    }

    private static int naive(String str, String match) {
        char[] strArr = str.toCharArray();
        char[] matchArr = match.toCharArray();

        for(int i=0; i<strArr.length; i++) {
            int temp = i;
            for(int j=0; j<matchArr.length; j++) {
                if(i>= strArr.length) {
                    return -1;
                }
                if(strArr[i] != matchArr[j]) {
                    i = temp;
                    break;
                }
                if(j+1==matchArr.length) {
                    return temp;
                }
                i++;
            }
        }
        return -1;
    }
}
