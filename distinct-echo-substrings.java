import java.util.HashSet;

class Solution {
    public int distinctEchoSubstrings(String text) {
        
        HashSet<String> set = new HashSet<>();
        int len = text.length();
        for (int i = 0; i < len-1; ++i) {
            for (int j = 1; i+j+j <= len; ++j) {
                if (text.substring(i, i+j).equals(text.substring(i+j, i+j+j)))
                    set.add(text.substring(i, i+j));
            }
        }
        
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distinctEchoSubstrings("tkfbgwgqvdsbnukcpxlpifuhbvtdxhhhqurotspohiuwhblnra"));
    }
}