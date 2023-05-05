package Strings;

public class LongestPalSubstring {

    public static void main(String[] args) {
        String t1 = "babad";
        String t2 = "bb";
        String t3 = "drqntbqsvukvfpuhogbugrabbaaswvunjabwklzyhkaprahuiauznlkubizqnqjxefcvxmrttnunnsbgdbxciatdzlfnssevnejzmemgjjlzqhsvfhzztsyakcmebeflwozoltixvpbbcwbknxjfwtrwdprqnmshcjvzdumggeolxnrzyiyhnclbfurbvpdxsqihwlxdlvdxjdvqdvjkcvhfcaejmewuzrbyvucmkbhwkvhhdoapcyoyyopwbuoymfiydyickejbkindktnwmebgywvgkiwcvjwpbizmxukuzkbdhfdfukkiqribflqeixdljnwvgoruqppimenzhmxfutqagiznlgczgltcbsjhfdpapbgxouvqqqvtlowetbqqdihzfgcvoxbsbkmtqfasbupybdqmmppfznfwphzodnpwupedcafwymrhomlqgnysozdwxbpkhfmczfmfejxmdqfgozwxaywiwkpafnxolvcqgikdugczrzwwxlkvjzexzzilfbbdouxrvqjpurndnujrbpeqvlevdcanssxwvqiyqhxksszxxfjjgqhxezbzlusgfyxmcaxsswwcrmsxdofcityoyispaooxsepebuxmriuuklypydirutguqyxhmhdsypqzuxdymqpqgdoybgofidoczhtiubcjkcozcrbkdwhqqutztwespbtetnhermzlislmqncvnexklnsvssrpwtsxzhkbwtsdrdpwyqamepuwdzmiwuoejvdzvvcuzjcepwiokuededdmozmzjcecinwccrdykeqdlikgfydmqredjtykdgralabfknkhxexfwafvkmfhblxnsgbywpztehwaiiiyxbkjqzrdwdhxfxxzbiqyhmtdepibqjnduvrvchkdiffxfjbngncdjqvkhwqzkefnvypwnqdgkleoteiqsqyohzsyllkeiaiircdohjrgeuhkodbmzdutpphlugwsmusitvet";
        System.out.println("TEST1: " + t1 + " ANS: " + longestPalindrome(t1));
        System.out.println("TEST2: " + t2 + " ANS: " + longestPalindrome(t2));
//        System.out.println("TEST3: " + t3 + " ANS: " + longestPalindrome(t3));
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        return helper(s.toCharArray(), 0, "");
    }


    private static String helper(char[] arr, int index, String currString) {
        System.out.println("Curr String: " + currString + " index: " + index);
        if(index == arr.length) {
            if(isPal(currString)) {
                return currString;
            }
            return "";
        }

        // Pick...
        System.out.println("PICKING: " + currString + arr[index]);
        String pick = helper(arr, index+1, currString+arr[index]);
        // Not Pick...
        System.out.println("NOT PICKING: " + "");
        String notPick = helper(arr, index+1, "");

        if(pick.length() < notPick.length()) {
            System.out.println("returning not pick: " + notPick);
            return notPick;
        }else {
            System.out.println("returning pick: " + pick);
            return pick;
        }
    }

    private static boolean isPal(String str) {
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != arr[arr.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
