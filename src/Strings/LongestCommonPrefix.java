package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[] {"fl","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String first = strs[0];

        for (int charPos=0; charPos<first.length(); charPos++) {
            for(int i=1; i<strs.length; i++) {
                if(strs[i].length()-1 < charPos || strs[i].charAt(charPos) != first.charAt(charPos)) {
                    return sb.toString();
                }
            }
            sb.append(first.charAt(charPos));
        }

        return sb.toString();
    }
}
