class Solution {
    public boolean isValid(String s) {
        Stack<Character> c = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                c.push(ch);
                continue;
            }
            if (c.isEmpty())
                return false;
            char check;
            switch (ch) {
                case ')':
                    check = c.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;
                case '}':
                    check = c.pop();
                    if (check == '[' || check == '(') {
                        return false;
                    }
                    break;
                case ']':
                    check = c.pop();
                    if (check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }
        }
        return (c.isEmpty());
    }
}
