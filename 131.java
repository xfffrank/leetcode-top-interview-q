class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> curr = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<String> (curr));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (isPal(s, start, end)) {
                    curr.add(s.substring(start, end + 1));
                    dfs(s, end + 1);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    public boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}