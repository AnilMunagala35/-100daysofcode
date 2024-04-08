class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] m = s.toCharArray();
        char[] n = t.toCharArray();
        Arrays.sort(m);
        Arrays.sort(n);
        for (int i = 0; i < m.length; i++) {
            if (m[i] != n[i]) {
                return false;
            }
        }
        return true;
    }
}
